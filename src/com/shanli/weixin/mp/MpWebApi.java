package com.shanli.weixin.mp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.bean.LangEnum;
import com.shanli.weixin.bean.RespCodes;
import com.shanli.weixin.mp.bean.Ticket;
import com.shanli.weixin.mp.bean.TicketTypeEnum;
import com.shanli.weixin.mp.resp.user.UserInfoResp;
import com.shanli.weixin.open.OpenApi;
import com.shanli.weixin.open.resp.OAuthAccessToken;
import com.shanli.weixin.util.ExpiresUtil;
import com.shanli.weixin.util.HttpUtil;
import com.shanli.weixin.util.aes.AesException;
import com.shanli.weixin.util.aes.SHA1;

/**
 * 网页开发API
 * 
 * @author alex
 *
 */
public class MpWebApi {
	private MpApi mpApi;

	public MpWebApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 获取ticket。此方法实现已经兼容开放平台模式。 优先从缓存中获取，否则从接口请求。
	 * 
	 * @type wx_card/jsapi
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	String apiGetTicket(TicketTypeEnum type)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		// 从缓存中查找
		Ticket ticket = mpApi.runtime.getTickets().get(type);
		if (!ExpiresUtil.isNeedUpdate(ticket)) {
			return ticket.getTicket();
		}

		String accessToken = null;
		// 开放平台模式应当使用ComponentAccessToken获取
		if (mpApi.config.isOpenMode()) {
			accessToken = OpenApi.getInstance().apiComponentToken().getComponentAccessToken();
		} else {
			accessToken = mpApi.apiToken().getAccessToken();
		}
		String path = String.format("/ticket/getticket?access_token=%s&type=%s", accessToken, type);
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		Ticket resp = new Gson().fromJson(respText, Ticket.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiGetTicket %s", new Gson().toJson(resp)));
		}
		if (resp.getErrcode() == null || RespCodes.OK.equals(resp.getErrcode())) {// 成功获取
			mpApi.runtime.getTickets().put(type, ticket);
			return resp.getTicket();
		}

		throw new IllegalArgumentException(String.format("ticket获取失败 %s", resp));
	}

	/**
	 * 获得JsApi签名。jsapi_ticket在方法内自动获取。
	 * 
	 * @param noncestr
	 * @param timestamp
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws NoSuchAlgorithmException
	 * @throws AesException
	 * @throws AccessTokenFailException
	 */
	public String apiGetJsApiSignature(String noncestr, int timestamp, String url) throws ClientProtocolException,
			URISyntaxException, IOException, NoSuchAlgorithmException, AesException, AccessTokenFailException {
		String jsApiTicket = apiGetTicket(TicketTypeEnum.jsapi);
		Hashtable<String, Object> params = new Hashtable<String, Object>();
		params.put("jsapi_ticket", jsApiTicket);
		params.put("noncestr", noncestr);
		params.put("timestamp", timestamp);
		params.put("url", url);
		return SHA1.getSHA1(params);
	}

	/**
	 * 获取微信用户网页授权AccessToken。如果是开放平台模式则此方法内部会调用OpenApi中获取。
	 * 由于此api使用频次比较低，因此未进行缓存，要求业务系统保存OAuthAccessToken,特别是其中的refresh_token。
	 * 如果网页授权的作用域为snsapi_base，则本步骤中获取到网页授权access_token的同时，也获取到了openid，snsapi_base式的网页授权流程即到此为止。
	 * 
	 * @param code
	 * 
	 * @return
	 * @throws AccessTokenFailException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ParseException
	 */
	public OAuthAccessToken apiSnsOAuth2AccessToken(String code)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		if (mpApi.config.isOpenMode()) {// 公众平台模式
			return OpenApi.getInstance().apiSnsOAuth2ComponentAccessToken(mpApi.appid, code);
		}
		String path = String.format("/oauth2/access_token?mpApi.appid=%s&secret=%s&code=%s&grant_type=authorization_code",
				mpApi.config.getAppId(), mpApi.config.getAppSecret(), code);
		String respText = HttpUtil.get(mpApi.config.getApiOAuth(), path);
		OAuthAccessToken resp = new Gson().fromJson(respText, OAuthAccessToken.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiSnsOAuth2AccessToken %s", resp));
		}
		return resp;
	}

	/**
	 * 刷新微信用户网页授权AccessToken。如果是开放平台模式则此方法内部会调用OpenApi中获取。
	 * 由于此api使用频次比较低，因此未进行缓存，要求业务系统保存OAuthAccessToken,特别是其中的refresh_token。
	 * 
	 * @param refreshToken
	 * @return
	 * @throws AccessTokenFailException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ParseException
	 */
	public OAuthAccessToken apiSnsOAuth2RefreshToken(String refreshToken)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		if (mpApi.config.isOpenMode()) {// 公众平台模式
			return OpenApi.getInstance().apiSnsOAuth2ComponentRefreshToken(mpApi.appid, refreshToken);
		}
		String path = String.format("/oauth2/refresh_token?mpApi.appid=%s&grant_type=refresh_token&refresh_token=%s",
				mpApi.config.getAppId(), refreshToken);
		String respText = HttpUtil.get(mpApi.config.getApiOAuth(), path);
		OAuthAccessToken resp = new Gson().fromJson(respText, OAuthAccessToken.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiSnsOAuth2RefreshToken %s", resp));
		}
		return resp;

	}

	/**
	 * 获取用户基本信息（需授权作用域为snsapi_userinfo）
	 * 
	 * @param oauthAccessToken
	 * @param openid
	 * @param lang
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public UserInfoResp apiSnsUserinfo(String oauthAccessToken, String openid, LangEnum lang)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		String path = String.format("/oauth2/component/refresh_token?access_token=%s&openid=%s&lang=%s",
				oauthAccessToken, openid, lang);
		String respText = HttpUtil.get(mpApi.config.getApiOAuth(), path);
		UserInfoResp resp = new Gson().fromJson(respText, UserInfoResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiOAuth2ComponentRefreshToken %s", resp));
		}
		return resp;
	}

	/**
	 * 检验OAuthAccessToken凭证是否有效
	 * 
	 * @param oauthAccessToken
	 * @param openid
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public BaseResp apiSnsAuth(String oauthAccessToken, String openid)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		String path = String.format("/auth?access_token=%s&openid=%s", oauthAccessToken, openid);
		String respText = HttpUtil.get(mpApi.config.getApiOAuth(), path);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiSnsAuth %s", resp));
		}
		return resp;

	}
}
