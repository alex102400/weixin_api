package com.shanli.weixin.mp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.RespCodes;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.resp.QrcodeCreateResp;
import com.shanli.weixin.mp.resp.ShortUrlResp;
import com.shanli.weixin.open.OpenApi;
import com.shanli.weixin.util.ExpiresUtil;
import com.shanli.weixin.util.HttpUtil;
import com.shanli.weixin.util.aes.AesException;
import com.shanli.weixin.util.aes.SHA1;

/**
 * 公众号接口。
 * 
 * @author alex
 *
 */
public class MpApi {
	final Log log;
	/**
	 * 实例缓存<appid,MpApi>
	 */
	private static final Hashtable<String, MpApi> INSTANCES = new Hashtable<String, MpApi>();
	// 公众号appid
	String appid;
	// 配置
	MpApiConfig config;
	// 运行时变量
	MpApiRuntime runtime = new MpApiRuntime();

	// 菜单API
	MpMenuApi menuApi;

	// 消息管理API
	MpMsgApi msgApi;

	// 素材管理API
	MpMaterialApi materialApi;

	// 用户管理API
	MpUserApi userApi;

	// 网页开发API
	MpWebApi webApi;

	// 数据统计API
	MpDataCubeApi dateCubeApi;

	// 客服API
	MpCustomServiceApi customServiceApi;

	// 被动回复API
	MpReplyApi replyApi;

	// 单例
	private MpApi(String appid) {
		this.appid = appid;
		log = LogFactory.getLog(MpApi.class);
	}

	/**
	 * 获得实例。并默认初始化为开放平台模式，可以通过init方法初始化为公众平台模式。
	 * 
	 * @param appid
	 * @return
	 */
	public static MpApi getInstance(String appid) {
		MpApi api = INSTANCES.get(appid);
		if (api == null) {// 首次创建
			api = new MpApi(appid);
			api.config = new MpApiConfig(appid);
			INSTANCES.put(appid, api);
		}
		return api;
	}

	/**
	 * 初始化为公众平台开发者模式。
	 * 
	 * @param config
	 */
	public void init(MpApiConfig config) {
		this.config = config;
	}

	/**
	 * 菜单API
	 * 
	 * @return
	 */
	public MpMenuApi getMenuApi() {
		if (menuApi == null) {
			menuApi = new MpMenuApi(this);
		}
		return menuApi;
	}

	/**
	 * 消息管理API
	 * 
	 * @return
	 */
	public MpMsgApi getMsgApi() {
		if (msgApi == null) {
			msgApi = new MpMsgApi(this);
		}
		return msgApi;
	}

	/**
	 * 网页开发API
	 * 
	 * @return the webApi
	 */
	public MpWebApi getWebApi() {
		return webApi;
	}

	/**
	 * 素材管理API
	 * 
	 * @return
	 */
	public MpMaterialApi getMaterialApi() {
		if (materialApi == null) {
			materialApi = new MpMaterialApi(this);
		}
		return materialApi;
	}

	/**
	 * 用户管理API
	 * 
	 * @return
	 */
	public MpUserApi getUserApi() {
		if (userApi == null) {
			userApi = new MpUserApi(this);
		}
		return userApi;
	}

	/**
	 * 数据统计API
	 * 
	 * @return the datecubeApi
	 */
	public MpDataCubeApi getDateCubeApi() {
		if (dateCubeApi == null) {
			dateCubeApi = new MpDataCubeApi(this);
		}
		return dateCubeApi;
	}

	/**
	 * 客服API
	 * 
	 * @return the customServiceApi
	 */
	public MpCustomServiceApi getCustomServiceApi() {
		if (customServiceApi == null) {
			customServiceApi = new MpCustomServiceApi(this);
		}
		return customServiceApi;
	}

	/**
	 * 被动回复API
	 * 
	 * @return the replyApi
	 */
	public MpReplyApi getReplyApi() {
		if (replyApi == null) {
			replyApi = new MpReplyApi(this);
		}
		return replyApi;
	}

	/**
	 * 验证微信服务器URL。用于公众平台开发者模式，不适用于开放平台模式。
	 * 
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @param signature
	 * @return
	 * @throws AesException
	 */
	public boolean verifyWeixinUrl(String token, String timestamp, String nonce, String signature) throws AesException {
		String sign = SHA1.getSHA1(token, timestamp, nonce);
		if (StringUtils.equals(signature, sign)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取access_token。优先使用缓存。如果是开放平台模式则此方法内部会调用OpenApi中获取。
	 * 
	 * @return
	 * @throws AccessTokenFailException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ParseException
	 */
	MpAccessToken apiToken() throws AccessTokenFailException {
		MpAccessToken accessToken = runtime.getAccessToken();
		if (!ExpiresUtil.isNeedUpdate(accessToken)) {
			return accessToken;
		}
		// 开放平台模式则通过OpenApi进行获取。
		if (config.isOpenMode()) {
			accessToken = OpenApi.getInstance().getMpAccessToken(config.getAppId());
			runtime.setAccessToken(accessToken);
			return accessToken;
		}

		// 公众平台开发模式调用api获取
		String path = String.format("/token?grant_type=client_credential&appid=%s&secret=%s", config.getAppId(),
				config.getAppSecret());
		// 构建请求参数进行获取
		String respText = null;
		try {
			respText = HttpUtil.get(config.getApiHttps(), path);
		} catch (Exception e) {
			throw new AccessTokenFailException("获取MpAccessToken异常!", e);
		}
		MpAccessToken resp = new Gson().fromJson(respText, MpAccessToken.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiToken %s", new Gson().toJson(resp)));
		}
		if (resp.getErrcode() == null || RespCodes.OK.equals(resp.getErrcode())) {
			runtime.setAccessToken(resp);
			return resp;
		}
		throw new AccessTokenFailException(String.format("获取MpAccessToken失败! %s", resp));

	}

	/**
	 * 创建临时二维码
	 * 
	 * @param seconds
	 *            该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）此字段如果不填，则默认有效期为30秒。
	 * @param sceneId
	 *            场景值ID，临时二维码时为32bit非0整型
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public QrcodeCreateResp apiQrcodeCreateTemp(Integer seconds, int sceneId)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = apiToken();
		String path = String.format("/qrcode/create?access_token=%s", token.getAccessToken());

		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("expire_seconds", seconds);
		reqMap.put("action_name", "QR_SCENE");
		TreeMap<String, Object> actionInfo = new TreeMap<String, Object>();
		TreeMap<String, Object> scene = new TreeMap<String, Object>();
		scene.put("scene_id", sceneId);
		actionInfo.put("scene", scene);
		reqMap.put("action_info", actionInfo);

		String respText = HttpUtil.post(config.getApiHttps(), path, reqMap);
		QrcodeCreateResp resp = new Gson().fromJson(respText, QrcodeCreateResp.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiQrcodeCreateTemp %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 创建永久二维码。
	 * 
	 * @param sceneStrOrId
	 *            场景值ID，可以为字符串或数值。字符串长度限制为1到64，数值1-100000。
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public QrcodeCreateResp apiQrcodeCreate(Object sceneStrOrId)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = apiToken();
		String path = String.format("/qrcode/create?access_token=%s", token.getAccessToken());

		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("action_name", "QR_LIMIT_SCENE");
		TreeMap<String, Object> actionInfo = new TreeMap<String, Object>();
		TreeMap<String, Object> scene = new TreeMap<String, Object>();
		if (sceneStrOrId instanceof String) {
			scene.put("scene_str", sceneStrOrId);
		} else {
			scene.put("scene_id", sceneStrOrId);
		}
		actionInfo.put("scene", scene);
		reqMap.put("action_info", actionInfo);

		String respText = HttpUtil.post(config.getApiHttps(), path, reqMap);
		QrcodeCreateResp resp = new Gson().fromJson(respText, QrcodeCreateResp.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiQrcodeCreate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获得二维码图片地址。可以直接展示或者下载。
	 * 
	 * @param ticket
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws MalformedURLException
	 */
	public URL apiQrcodeUrl(String ticket) throws UnsupportedEncodingException, MalformedURLException {
		String encode = URLEncoder.encode(ticket, "utf-8");
		return new URL(String.format("%s/showqrcode?ticket=%s", config.getApiHttps(), encode));
	}

	/**
	 * 
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public ShortUrlResp apiShortUrl(String url)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = apiToken();
		String path = String.format("/shorturl?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("action", "long2short");
		reqMap.put("long_url", url);
		String respText = HttpUtil.post(config.getApiHttps(), path, reqMap);
		ShortUrlResp resp = new Gson().fromJson(respText, ShortUrlResp.class);
		if (log.isInfoEnabled()) {
			log.info(String.format("apiShortUrl %s", new Gson().toJson(resp)));
		}
		return resp;
	}

}
