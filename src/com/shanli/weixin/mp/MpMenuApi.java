package com.shanli.weixin.mp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TreeMap;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.Button;
import com.shanli.weixin.mp.bean.Matchrule;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.resp.menu.GetCurrentSelfMenuInfoResp;
import com.shanli.weixin.mp.resp.menu.MenuAddconditionalResp;
import com.shanli.weixin.mp.resp.menu.MenuGetResp;
import com.shanli.weixin.mp.resp.menu.MenuTrymatchResp;
import com.shanli.weixin.util.HttpUtil;

/**
 * 公众平台菜单API
 * 
 * @author alex
 *
 */
public class MpMenuApi {
	private MpApi mpApi;

	public MpMenuApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 获取当前生效的自定义菜单配置接口。
	 * 本接口与自定义菜单查询接口的不同之处在于，本接口无论公众号的接口是如何设置的，都能查询到接口，而自定义菜单查询接口则仅能查询到使用API设置的菜单配置。
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public GetCurrentSelfMenuInfoResp apiGetCurrentSelfMenuInfo()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();

		String path = String.format("/get_current_selfmenu_info?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetCurrentSelfMenuInfoResp resp = new Gson().fromJson(respText, GetCurrentSelfMenuInfoResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiGetCurrentSelfMenuInfo %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 自定义菜单查询接口
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public MenuGetResp apiMenuGet()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/menu/get?access_token=%s", token.getAccessToken());
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		MenuGetResp resp = new Gson().fromJson(respText, MenuGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMenuGet %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 自定义菜单创建接口 。 注意： 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
	 * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
	 * 3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
	 * 如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。
	 * 测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
	 * 
	 * @param buttons
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMenuCreate(Button[] buttons)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/menu/create?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, Button[]> reqMap = new TreeMap<String, Button[]>();
		reqMap.put("button", buttons);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMenuCreate %s", new Gson().toJson(resp)));
		}
		return resp;

	}

	/**
	 * 自定义菜单删除接口
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMenuDelete()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/menu/delete?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMenuDelete %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 创建个性化菜单
	 * 
	 * @param buttons
	 * @param matchrule
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MenuAddconditionalResp apiMenuAddconditional(Button[] buttons, Matchrule matchrule)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/menu/addconditional?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("button", buttons);
		reqMap.put("matchrule", matchrule);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		MenuAddconditionalResp resp = new Gson().fromJson(respText, MenuAddconditionalResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMenuAddconditional %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 删除个性化菜单
	 * 
	 * @param menuid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMenuDelconditional(String menuid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/menu/delete?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("menuid", menuid);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMenuDelconditional %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 测试个性化菜单匹配结果
	 * 
	 * @param openIdOrUserId
	 *            可以是粉丝的OpenID，也可以是粉丝的微信号。
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public MenuTrymatchResp apiMenuTrymatch(String openIdOrUserId)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/menu/trymatch?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("user_id", openIdOrUserId);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		MenuTrymatchResp resp = new Gson().fromJson(respText, MenuTrymatchResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMenuTrymatch %s", new Gson().toJson(resp)));
		}
		return resp;
	}

}
