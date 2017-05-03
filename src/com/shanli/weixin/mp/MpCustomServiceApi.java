package com.shanli.weixin.mp;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TreeMap;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.resp.cs.GetKfListResp;
import com.shanli.weixin.mp.resp.cs.GetKfOnlineListResp;
import com.shanli.weixin.mp.resp.cs.GetMsgListResp;
import com.shanli.weixin.mp.resp.cs.GetSessionResp;
import com.shanli.weixin.mp.resp.cs.GetWaitCaseResp;
import com.shanli.weixin.util.HttpUtil;

/**
 * 客服API
 * 
 * @author alex
 *
 */
public class MpCustomServiceApi {
	private MpApi mpApi;

	public MpCustomServiceApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 添加客服帐号。 开发者可以通过本接口为公众号添加客服账号，每个公众号最多添加10个客服账号。
	 * 
	 * @param account
	 *            完整客服账号，格式为：账号前缀@公众号微信号
	 * @param nickname
	 *            客服昵称
	 * @param passwordMD5_32
	 *            客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiCustomServiceKfAccountAdd(String account, String nickname, String passwordMD5_32)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfaccount/add?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("kf_account", account);
		reqMap.put("nickname", nickname);
		reqMap.put("password", passwordMD5_32);

		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfAccountAdd %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 邀请绑定客服帐号
	 * 
	 * @param account
	 * @param inviteWx
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiCustomServiceKfAccountInviteWorker(String account, String inviteWx)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfaccount/inviteworker?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("kf_account", account);
		reqMap.put("invite_wx", inviteWx);

		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfAccountAdd %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 修改客服帐号。
	 * 
	 * @param account
	 *            完整客服账号，格式为：账号前缀@公众号微信号
	 * @param nickname
	 *            客服昵称
	 * @param passwordMD5_32
	 *            客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiCustomServiceKfAccountUpdate(String account, String nickname, String passwordMD5_32)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfaccount/update?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("kf_account", account);
		reqMap.put("nickname", nickname);
		reqMap.put("password", passwordMD5_32);

		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfAccountUpdate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 删除客服帐号。
	 * 
	 * @param account
	 *            完整客服账号，格式为：账号前缀@公众号微信号
	 * @param nickname
	 *            客服昵称
	 * @param passwordMD5_32
	 *            客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiCustomServiceKfAccountDel(String account, String nickname, String passwordMD5_32)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfaccount/del?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("kf_account", account);
		reqMap.put("nickname", nickname);
		reqMap.put("password", passwordMD5_32);

		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfAccountDel %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 设置客服帐号的头像。
	 * 开发者可调用本接口来上传图片作为客服人员的头像，头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果。
	 * 
	 * @param account
	 * @param jpg640
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiCustomServiceKfAccountUploadHeadimg(String account, File jpg640)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfaccount/uploadheadimg?access_token=%s&kf_account=%s",
				token.getAccessToken(), account);

		String respText = HttpUtil.upload(mpApi.config.getApiHttp(), path, "media", jpg640);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfAccountUploadHeadimg %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取所有客服账号
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public GetKfListResp apiCustomServiceGetKfList()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/getkflist?access_token=%s", token.getAccessToken());

		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetKfListResp resp = new Gson().fromJson(respText, GetKfListResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceGetKfList %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获得在线客服信息
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public GetKfOnlineListResp apiCustomServiceGetOnlineKfList()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/getonlinekflist?access_token=%s", token.getAccessToken());

		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetKfOnlineListResp resp = new Gson().fromJson(respText, GetKfOnlineListResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceGetOnlineKfList %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 创建会话
	 * 
	 * @param account
	 * @param openid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiCustomServiceKfSessionCreate(String account, String openid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfsession/create?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("kf_account", account);
		reqMap.put("openid", openid);

		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfSessionCreate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 关闭会话
	 * 
	 * @param account
	 * @param openid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiCustomServiceKfSessionClose(String account, String openid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfsession/close?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("kf_account", account);
		reqMap.put("openid", openid);

		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfSessionCreate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取客户会话状态
	 * 
	 * @param openid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public GetSessionResp apiCustomServiceKfSessionGetSession(String openid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfsession/getsession?access_token=%s&openid=%s",
				token.getAccessToken(), openid);
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetSessionResp resp = new Gson().fromJson(respText, GetSessionResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfSessionGetSession %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public GetWaitCaseResp apiCustomServiceKfSessionGetWaitCase()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/kfsession/getwaitcase?access_token=%s", token.getAccessToken());
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetWaitCaseResp resp = new Gson().fromJson(respText, GetWaitCaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceKfSessionGetWaitCase %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取聊天记录
	 * 
	 * @param starttime
	 *            起始时间，unix时间戳
	 * @param endtime
	 *            结束时间，unix时间戳，每次查询时段不能超过24小时
	 * @param msgid
	 *            消息id顺序从小到大，从1开始
	 * @param number
	 *            每次获取条数，最多10000条
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public GetMsgListResp apiCustomServiceMsgRecordGetMsgList(Long starttime, Long endtime, Long msgid, Long number)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/customservice/msgrecord/getmsglist?access_token=%s", token.getAccessToken());
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetMsgListResp resp = new Gson().fromJson(respText, GetMsgListResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiCustomServiceMsgRecordGetMsgList %s", new Gson().toJson(resp)));
		}
		return resp;
	}
}
