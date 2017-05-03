package com.shanli.weixin.open;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TreeMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.bean.RespCodes;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.recv.UserMsg;
import com.shanli.weixin.mp.recv.UserMsgTypeEnum;
import com.shanli.weixin.mp.recv.event.MsgEvent;
import com.shanli.weixin.mp.recv.event.MsgEventTypeEnum;
import com.shanli.weixin.open.event.OpenEvent;
import com.shanli.weixin.open.event.OpenEventAuthorized;
import com.shanli.weixin.open.event.OpenEventTicket;
import com.shanli.weixin.open.event.OpenEventTypeEnum;
import com.shanli.weixin.open.event.OpenEventUnAuthorized;
import com.shanli.weixin.open.resp.AuthorizerAccessToken;
import com.shanli.weixin.open.resp.AuthorizerOption;
import com.shanli.weixin.open.resp.AuthorizerOptionEnum;
import com.shanli.weixin.open.resp.ComponentAccessToken;
import com.shanli.weixin.open.resp.GetAuthorizerInfo;
import com.shanli.weixin.open.resp.OAuthAccessToken;
import com.shanli.weixin.open.resp.PreAuthCode;
import com.shanli.weixin.open.resp.QueryAuth;
import com.shanli.weixin.util.ExpiresUtil;
import com.shanli.weixin.util.HttpUtil;
import com.shanli.weixin.util.XmlUtil;
import com.shanli.weixin.util.aes.AesException;
import com.shanli.weixin.util.aes.WXBizMsgCrypt;

/**
 * 微信开放平台调用接口API
 * 
 * @author alex
 *
 */
public class OpenApi {
	static final Log log = LogFactory.getLog(OpenApi.class);
	/**
	 * 单例
	 */
	private static final OpenApi instance = new OpenApi();
	/**
	 * 工作线程池
	 */
	private ScheduledThreadPoolExecutor worker;

	/**
	 * 参数配置
	 */
	private OpenApiConfig config;
	/**
	 * 运行时变量
	 */
	private OpenApiRuntime runtime;

	/**
	 * 是否已经初始化
	 */
	private volatile boolean inited = false;
	/**
	 * 公众号授权码与ID映射<authCode,appid>。用于用户授权成功页面回调后通过授权码查询APPID。
	 * 只保留最近的几个即可，授权并发量不可能很大。
	 * 
	 */
	private LRUMap mpAuthcode2Appids = new LRUMap(128);

	/**
	 * 消息与事件的ID缓存，用于去重。
	 */
	private LRUMap distinctMsgIdCache;

	/**
	 * 单例
	 */
	private OpenApi() {

	}

	/**
	 * 获得实例
	 * 
	 * @return 单例引用
	 */
	public static OpenApi getInstance() {
		return instance;
	}

	/**
	 * 初始化，只需要一次。主要工作是创建各类服务线程，例如Ticket获取线程。
	 * 
	 * @param config
	 *            参数配置
	 */
	public void init(OpenApiConfig config) {
		if (inited) {
			return;
		}
		inited = true;
		this.config = config;
		this.distinctMsgIdCache = new LRUMap(config.getDistinctMsgIdCacheSize());

		runtime = new OpenApiRuntime(config.getRuntimeStorage());

		// 创建工作线程池。
		worker = new ScheduledThreadPoolExecutor(config.getWorkerThreadPoolSize());
	}

	/**
	 * 停止服务
	 */
	public void shutdown() {
		if (worker != null) {
			worker.shutdownNow();
		}
		inited = false;
	}

	/**
	 * 开放平台授权事件处理器。接收component_verify_ticket、取消授权通知、授权成功通知、授权更新通知。
	 * 
	 * @param request
	 *            HTTP请求对象
	 * @return 解析后的事件对象，如果不能解析则返回null。
	 */
	public OpenEvent onEvent(HttpServletRequest request) {

		OpenEvent event = parseEvent(request);
		if (event == null) {
			log.warn(String.format("未能解析事件请求"));
			return null;
		}

		if (log.isInfoEnabled()) {
			log.info(String.format("事件 %s", new Gson().toJson(event)));
		}

		// 更新Ticket
		if (OpenEventTypeEnum.component_verify_ticket.equals(event.getInfoType())) {
			String ticket = ((OpenEventTicket) event).getComponentVerifyTicket();
			runtime.setComponentVerifyTicket(ticket);

		}
		// 公众号授权事件和授权更新事件。同时会有页面回调,页同上只有auth_code/expires_in参数。
		if (OpenEventTypeEnum.authorized.equals(event.getInfoType())
				|| OpenEventTypeEnum.updateauthorized.equals(event.getInfoType())) {
			OpenEventAuthorized evt = ((OpenEventAuthorized) event);
			final String mpAuthCode = evt.getAuthorizationCode();
			final String mpAppid = evt.getAuthorizerAppid();
			mpAuthcode2Appids.put(mpAuthCode, mpAppid);

		}
		// 公众号取消授权事件
		if (OpenEventTypeEnum.unauthorized.equals(event.getInfoType())) {
			OpenEventUnAuthorized evt = ((OpenEventUnAuthorized) event);
			final String mpAppid = evt.getAuthorizerAppid();
			// 移除公众号授权令牌缓存
			runtime.removeMpAuthorizerToken(mpAppid);
		}

		return event;
	}

	/**
	 * 消息处理
	 * 
	 * @param request
	 *            HTTP请求对象
	 * @return 解析后的消息对象，如果不能解析则返回null。
	 */
	public UserMsg onMessage(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		String appid = request.getParameter("appid");

		final UserMsg msg = parseMessage(request);
		if (msg == null) {
			log.warn(String.format("未能解析消息请求"));
			return null;
		}

		// 消息ID去重
		String msgid = msg.getMsgId();
		if (StringUtils.isEmpty(msgid)) {
			msgid = String.format("%s_%s", msg.getFromUserName(), msg.getCreateTime());
		}
		if (distinctMsgIdCache.containsKey(msgid)) {
			if (log.isInfoEnabled()) {
				log.info(String.format("丢弃重复消息[%s]，", msgid));
			}
			return null;
		}
		distinctMsgIdCache.put(msgid, null);

		if (log.isInfoEnabled()) {
			log.info(String.format("消息 %s", new Gson().toJson(msg)));
		}

		msg.setAppid(appid);
		msg.setOpenid(openid);
		return msg;
	}

	/**
	 * 全网发布检测。
	 * 
	 * @param msg
	 *            用户发过来的消息对象
	 * @return 返回检测消息的应答内容，应用层将返回内容响应给微信服务器即可。
	 */
	public String onPublishDetect(UserMsg msg) {
		return null;
	}

	/**
	 * 根据授权码获得公众号ID。 由于回调页面和授权事件是异步的，因此需要进行等待。
	 * 
	 * @param mpAuthcode
	 *            授权码
	 * @param maxWaitMilliseconds
	 *            最大等待秒数
	 * @return 返回授权码对应的Appid，并从缓存中移除。
	 * @throws TimeoutException
	 *             超时未能获取对应公众号appid
	 */
	public String waitMpAppidByAuthcode(String mpAuthcode, int maxWaitMilliseconds) throws TimeoutException {
		String mpAppid = null;
		try {
			while (mpAppid == null && maxWaitMilliseconds > 0) {
				mpAppid = (String) mpAuthcode2Appids.get(mpAuthcode);
				maxWaitMilliseconds -= 10;
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
		}
		if (mpAppid == null) {
			throw new TimeoutException("未能在指定时间内获得mpAuthcode对应的mpAppid");
		}

		return mpAppid;
	}

	/**
	 * 获取公众号AccessToken。优先使用缓存。
	 * 
	 * @param mpAppid
	 *            公众号appid
	 * @return 公众号访问令牌。可能为null。
	 * @throws AccessTokenFailException
	 *             获取令牌异常
	 */
	public MpAccessToken getMpAccessToken(String mpAppid) throws AccessTokenFailException {
		AuthorizerAccessToken aaToken = apiAuthorizerToken(mpAppid);
		if (aaToken == null) {
			return null;
		}
		MpAccessToken token = new MpAccessToken();
		token.setAccessToken(aaToken.getAuthorizerAccessToken());
		token.setExpiresIn(aaToken.getExpiresIn());
		return token;

	}

	/**
	 * 获取第三方平台component_access_token。优先使用缓存。
	 * 
	 * @return 开放平台访问令牌。
	 * @throws AccessTokenFailException
	 *             获取令牌异常
	 * 
	 */
	public ComponentAccessToken apiComponentToken() throws AccessTokenFailException {
		// 检查必要参数，Ticket是否存在
		String ticket = OpenApi.getInstance().getRuntime().getComponentVerifyTicket();
		if (StringUtils.isEmpty(ticket)) {
			throw new AccessTokenFailException("无法获取ComponentAccessToken,因为没有ComponentVerifyTicket");
		}

		// 检查是否有效，如果不需要更新则直接返回缓存对象
		ComponentAccessToken token = runtime.getComponentAccessToken();
		if (!ExpiresUtil.isNeedUpdate(token)) {
			return token;
		}

		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());
		reqMsg.put("component_appsecret", config.getComponentAppSecret());
		reqMsg.put("component_verify_ticket", ticket);

		String path = "/component/api_component_token";

		String respText = null;
		try {
			respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);
		} catch (Exception e) {
			throw new AccessTokenFailException("获取ComponentAccessToken失败!", e);
		}
		ComponentAccessToken resp = new Gson().fromJson(respText, ComponentAccessToken.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiComponentToken %s", resp));
		}
		// 如果令牌有效则保存并返回
		if (isApiRespOK(resp)) {
			runtime.setComponentAccessToken(resp);
			return resp;
		}

		throw new AccessTokenFailException(String.format("获取ComponentAccessToken失败! %s", resp));
	}

	/**
	 * 获取预授权码。 优先使用缓存。预授权码用于公众号授权时的第三方平台方安全验证。
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public PreAuthCode apiCreatePreAuthcode()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {

		// 检查有效性，不需要更新则返回缓存对象
		PreAuthCode precode = runtime.getPreAuthCode();
		if (!ExpiresUtil.isNeedUpdate(precode)) {
			return precode;
		}

		ComponentAccessToken caToken = apiComponentToken();

		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());

		String path = String.format("/component/api_create_preauthcode?component_access_token=%s",
				caToken.getComponentAccessToken());

		String respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);
		PreAuthCode resp = new Gson().fromJson(respText, PreAuthCode.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiCreatePreAuthcode %s", resp));
		}
		if (isApiRespOK(resp)) {
			runtime.setPreAuthCode(resp);
		}

		return resp;
	}

	/**
	 * 在公众号管理员授权时获取公众号的AccessToken。无缓存。首次授权时必需通过此方法获取AccessToken，平常使用apiAuthorizerToken方法获取。
	 * 授权码mpAuthcode在用户授权事件和授权回调页面中都可以获得。
	 * 
	 * @param mpAuthcode
	 * @return
	 * @throws AccessTokenFailException
	 * @throws TimeoutException
	 */
	public AuthorizerAccessToken apiQueryAuth(String mpAuthcode) throws AccessTokenFailException, TimeoutException {

		ComponentAccessToken caToken = apiComponentToken();

		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());
		reqMsg.put("authorization_code", mpAuthcode);
		String path = String.format("/component/api_query_auth?component_access_token=%s",
				caToken.getComponentAccessToken());

		String respText = null;
		try {
			respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);
		} catch (Exception e) {
			throw new AccessTokenFailException("获取MpAccessToken异常!", e);
		}
		// 注意：由于此时返回的func_info不准确，所以不进行解析，因此api_query_auth返回json直接解析为AuthorizerToken。
		QueryAuth resp = new Gson().fromJson(respText, QueryAuth.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiQueryAuth %s", resp));
		}

		AuthorizerAccessToken mpToken = resp.getAuthorizationInfo();
		String mpAppid = waitMpAppidByAuthcode(mpAuthcode, 15000);
		mpToken.setMpAppid(mpAppid);
		if (isApiRespOK(resp)) {
			runtime.putMpAuthorizerToken(mpAppid, mpToken);

			return mpToken;
		}

		throw new AccessTokenFailException(String.format("获取MpAccessToken失败! %s", resp));
	}

	/**
	 * 获取公众号的AccessToken。优先从缓存中获取。
	 * 
	 * @return
	 * @throws AccessTokenFailException
	 */
	public AuthorizerAccessToken apiAuthorizerToken(String mpAppid) throws AccessTokenFailException {
		// 检查有效性，不需要更新则返回缓存对象
		AuthorizerAccessToken mpToken = runtime.getMpAuthorizerToken(mpAppid);
		if (mpToken == null) {
			throw new AccessTokenFailException("不存在mpAppid对应的MpAccessToken,需要公众号管理员重新授权!");
		}
		if (!ExpiresUtil.isNeedUpdate(mpToken)) {
			return mpToken;
		}

		ComponentAccessToken caToken = apiComponentToken();

		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());
		reqMsg.put("authorizer_appid", mpAppid);
		reqMsg.put("authorizer_refresh_token", mpToken.getAuthorizerRefreshToken());
		String path = String.format("/component/api_authorizer_token?component_access_token=%s",
				caToken.getComponentAccessToken());

		String respText = null;
		try {
			respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);
		} catch (Exception e) {
			throw new AccessTokenFailException("获取MpAccessToken异常!", e);
		}
		AuthorizerAccessToken resp = new Gson().fromJson(respText, AuthorizerAccessToken.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiAuthorizerToken %s", resp));
		}
		resp.setMpAppid(mpAppid);

		if (isApiRespOK(resp)) {
			runtime.putMpAuthorizerToken(mpAppid, resp);

			return resp;
		} else if (RespCodes.INVALID_APPID.equals(resp.getErrcode())) {// appid错误的应当从缓存中移除
			runtime.removeMpAuthorizerToken(mpAppid);
		}

		throw new AccessTokenFailException(String.format("获取MpAccessToken失败! %s", resp));
	}

	/**
	 * 获取公众号基本信息。
	 * 
	 * @param mpAppid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public GetAuthorizerInfo apiGetAuthorizerInfo(String mpAppid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {

		// 检查MpAccessToken是否存在
		AuthorizerAccessToken mpToken = runtime.getMpAuthorizerToken(mpAppid);
		if (mpToken == null) {
			throw new IllegalStateException("无法获取公众号基本信息,因为MpAccessToken不存在");
		}

		ComponentAccessToken caToken = apiComponentToken();
		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());
		reqMsg.put("authorizer_appid", mpAppid);
		String path = String.format("/component/api_get_authorizer_info?component_access_token=%s",
				caToken.getComponentAccessToken());

		String respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);
		GetAuthorizerInfo resp = new Gson().fromJson(respText, GetAuthorizerInfo.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiGetAuthorizerInfo %s", resp));
		}

		return resp;
	}

	/**
	 * 获取公众号的选项设置信息集。
	 * 
	 * @param mpAppid
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public AuthorizerOption[] apiGetAuthorizerOptions(String mpAppid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		// 检查MpAccessToken是否存在
		AuthorizerAccessToken authToken = runtime.getMpAuthorizerToken(mpAppid);
		if (authToken == null) {
			throw new IllegalStateException("无法获取公众号选项设置信息,因为MpAccessToken不存在");
		}

		AuthorizerOptionEnum[] optionDefines = AuthorizerOptionEnum.values();
		int length = optionDefines.length;
		AuthorizerOption[] authOptions = new AuthorizerOption[length];
		for (int idx = 0; idx < length; idx++) {
			AuthorizerOption authOption = apiGetAuthorizerOption(mpAppid, optionDefines[idx]);
			authOptions[idx] = authOption;
		}

		return authOptions;
	}

	/**
	 * 获取授权方的选项设置信息。
	 * 
	 * @param mpAppid
	 * @param option
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public AuthorizerOption apiGetAuthorizerOption(String mpAppid, AuthorizerOptionEnum option)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {

		// 检查MpAccessToken是否存在
		AuthorizerAccessToken mpToken = runtime.getMpAuthorizerToken(mpAppid);
		if (mpToken == null) {
			throw new IllegalStateException("无法获取公众号选项设置信息,因为MpAccessToken不存在");
		}

		ComponentAccessToken caToken = apiComponentToken();
		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());
		reqMsg.put("authorizer_appid", mpAppid);
		reqMsg.put("option_name", option.name());
		String path = String.format("/component/api_get_authorizer_option?component_access_token=%s",
				caToken.getComponentAccessToken());
		String respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);
		AuthorizerOption resp = new Gson().fromJson(respText, AuthorizerOption.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiGetAuthorizerOption %s", resp));
		}
		return resp;

	}

	/**
	 * 设置授权方的选项信息。
	 * 该API用于设置授权方的公众号的选项信息，如：地理位置上报，语音识别开关，多客服开关。注意，设置各项选项设置信息，需要有授权方的授权，详见权限集说明。
	 * 
	 * @param mpAppid
	 * @param option
	 * @param value
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiSetAuthorizerOption(String mpAppid, AuthorizerOptionEnum option, String value)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {

		// 检查MpAccessToken是否存在
		AuthorizerAccessToken authToken = runtime.getMpAuthorizerToken(mpAppid);
		if (authToken == null) {
			throw new IllegalStateException("无法设置公众号选项信息,因为MpAccessToken不存在");
		}

		ComponentAccessToken token = apiComponentToken();

		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());
		reqMsg.put("authorizer_appid", mpAppid);
		reqMsg.put("option_name", option.name());
		reqMsg.put("option_value", value);

		String path = String.format("/component/api_set_authorizer_option?component_access_token=%s",
				token.getComponentAccessToken());
		String respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);

		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiSetAuthorizerOption %s", resp));
		}
		return resp;
	}

	/**
	 * 第三方平台对其所有API调用次数清零。每个月10次。
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiClearQuota()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {

		// 构建请求参数进行获取
		TreeMap<String, String> reqMsg = new TreeMap<String, String>();
		reqMsg.put("component_appid", config.getComponentAppid());

		ComponentAccessToken token = apiComponentToken();
		String path = String.format("/component/clear_quota?component_access_token=%s",
				token.getComponentAccessToken());

		String respText = HttpUtil.post(config.getApiHttps(), path, reqMsg);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiClearQuota %s", resp));
		}
		return resp;
	}

	/**
	 * 获取微信用户网页授权AccessToken。
	 * 由于此api使用频次比较低，因此要求业务系统保存OAuthAccessToken,特别是其中的refresh_token。
	 * 如果网页授权的作用域为snsapi_base，则本步骤中获取到网页授权access_token的同时，也获取到了openid，snsapi_base式的网页授权流程即到此为止。
	 * 
	 * @param mpAppid
	 * @param code
	 * 
	 * @return
	 * @throws AccessTokenFailException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ParseException
	 */
	public OAuthAccessToken apiSnsOAuth2ComponentAccessToken(String mpAppid, String code)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		ComponentAccessToken caToken = apiComponentToken();
		String path = String.format(
				"/oauth2/component/access_token?appid=%s&code=%s&grant_type=authorization_code&component_appid=%s&component_access_token=%s",
				mpAppid, code, config.getComponentAppid(), caToken.getComponentAccessToken());

		String respText = HttpUtil.get(config.getApiOAuth(), path);
		OAuthAccessToken resp = new Gson().fromJson(respText, OAuthAccessToken.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiOAuth2ComponentAccessToken %s", resp));
		}
		return resp;

	}

	/**
	 * 刷新微信用户网页授权AccessToken。
	 * 
	 * @param mpAppid
	 * @param refreshToken
	 * @return
	 * @throws AccessTokenFailException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ParseException
	 */
	public OAuthAccessToken apiSnsOAuth2ComponentRefreshToken(String mpAppid, String refreshToken)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		ComponentAccessToken caToken = apiComponentToken();
		String path = String.format(
				"/oauth2/component/refresh_token?appid=%s&grant_type=refresh_token&component_appid=%s&component_access_token=%s&refresh_token=%s",
				mpAppid, config.getComponentAppid(), caToken.getComponentAccessToken(), refreshToken);

		String respText = HttpUtil.get(config.getApiOAuth(), path);
		OAuthAccessToken resp = new Gson().fromJson(respText, OAuthAccessToken.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiOAuth2ComponentRefreshToken %s", resp));
		}
		return resp;
	}

	/**
	 * api调用返回错误码时回调业务接口
	 * 
	 * @param errcode
	 */
	private boolean isApiRespOK(final BaseResp resp) {
		if (resp == null) {
			return false;
		}
		if (resp.getErrcode() == null || RespCodes.OK.equals(resp.getErrcode())) {
			return true;
		}
		return false;
	}

	/**
	 * 读取请求体数据，并解密为XML
	 * 
	 * @param requestData
	 * @return
	 */
	private String readRequestBodyAndDecryptToXml(HttpServletRequest req) {
		// 读取请求数据体
		String reqData = null;
		try {
			reqData = IOUtils.toString(req.getInputStream());
			if (log.isDebugEnabled()) {
				log.debug("请求数据： \n" + reqData);
			}
		} catch (IOException e) {
			log.error("读取请求体数据异常", e);
		}
		if (StringUtils.isBlank(reqData)) {
			return null;
		}

		// 解密XML
		// String sign =
		// params.getParameter("signature");//消息签名验证。1）将token、timestamp、nonce三个参数进行字典序排序
		// 2）将三个参数字符串拼接成一个字符串进行sha1加密 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		String time = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String type = req.getParameter("encrypt_type");
		String msign = req.getParameter("msg_signature");
		String xml = null;

		if (StringUtils.equals("aes", type) && StringUtils.contains(reqData, "Encrypt")) {
			try {
				WXBizMsgCrypt wxmc = new WXBizMsgCrypt(config.getComponentToken(), config.getComponentEncodingAesKey(),
						config.getComponentAppid());
				xml = wxmc.decryptMsg(msign, time, nonce, reqData);
				if (log.isDebugEnabled()) {
					log.debug(String.format("解密XML \n %s", xml));
				}
			} catch (AesException e) {
				log.error(String.format("解密微信消息异常 %s \n %s", new Gson().toJson(req.getParameterMap()), xml), e);
				return null;
			}
		}
		return xml;
	}

	/**
	 * 事件解析。
	 * 
	 * @param requestData
	 * @return
	 */
	private UserMsg parseMessage(HttpServletRequest request) {
		try {
			String xml = readRequestBodyAndDecryptToXml(request);
			if (StringUtils.isEmpty(xml)) {
				return null;
			}

			// 读取XML根据InfoType转换为对应事件对象
			XmlUtil xu = new XmlUtil(xml);
			String msgTypeName = xu.getXmlNodeText("MsgType");
			if (StringUtils.isEmpty(msgTypeName)) {
				log.error(String.format("缺少MsgType字段 %s", xml));
				return null;
			}
			UserMsgTypeEnum msgType;
			try {
				msgType = UserMsgTypeEnum.valueOf(msgTypeName);
			} catch (Exception e) {
				log.error(String.format("无法识别消息类型 %s", xml));
				return null;
			}
			Class<? extends UserMsg> clazz = msgType.getClazz();
			// 事件消息进行特殊处理
			MsgEventTypeEnum eventType = null;
			if (UserMsgTypeEnum.event.equals(msgType)) {
				String eventName = xu.getXmlNodeText("Event");// 事件类型
				try {
					eventType = MsgEventTypeEnum.valueOf(eventName);
				} catch (Exception e) {
					log.error(String.format("无法识别事件消息类型 %s", xml));
					return null;
				}
				clazz = eventType.getClazz();
			}

			UserMsg msg = xu.toObject(clazz);
			msg.setType(msgType);// 消息类型
			if (eventType != null) {// 事件类型
				((MsgEvent) msg).setEventType(eventType);
			}
			return msg;
		} catch (Exception e) {
			log.error(String.format("XML转换为消息对象异常"), e);
		}

		return null;
	}

	/**
	 * 事件解析。
	 * 
	 * @param requestData
	 * @return
	 */
	private OpenEvent parseEvent(HttpServletRequest request) {
		String xml = readRequestBodyAndDecryptToXml(request);
		if (StringUtils.isEmpty(xml)) {
			log.error("无法读取请求体数据 %s");
			return null;
		}

		// 读取XML根据InfoType转换为对应事件对象
		XmlUtil xu = new XmlUtil(xml);
		String infoType = xu.getXmlNodeText("InfoType");

		OpenEventTypeEnum eventType = OpenEventTypeEnum.valueOf(infoType);
		if (eventType == null) {
			log.error(String.format("无法识别事件类型 %s", infoType));
			return null;
		}
		Class<? extends OpenEvent> clazz = eventType.getClazz();
		try {
			OpenEvent evt = xu.toObject(clazz);
			evt.setInfoType(eventType);
			return evt;
		} catch (Exception e) {
			log.error(String.format("XML转换为事件对象异常 %s %s", clazz, xml), e);
		}

		return null;
	}

	public OpenApiConfig getConfig() {
		return config;
	}

	public void setConfig(OpenApiConfig config) {
		this.config = config;
	}

	public OpenApiRuntime getRuntime() {
		return runtime;
	}

	public void setRuntime(OpenApiRuntime runtime) {
		this.runtime = runtime;
	}

	/**
	 * 获取工作线程池引用
	 * 
	 * @return the worker
	 */
	public ScheduledThreadPoolExecutor getWorker() {
		return worker;
	}

}
