package com.shanli.weixin.mp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TreeMap;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.bean.LangEnum;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.resp.user.TagsCreateResp;
import com.shanli.weixin.mp.resp.user.TagsGetIdListResp;
import com.shanli.weixin.mp.resp.user.TagsGetResp;
import com.shanli.weixin.mp.resp.user.UserGetResp;
import com.shanli.weixin.mp.resp.user.UserInfoBatchGetResp;
import com.shanli.weixin.mp.resp.user.UserInfoResp;
import com.shanli.weixin.util.HttpUtil;

/**
 * 公众号用户管理API
 * 
 * @author alex
 *
 */
public class MpUserApi {
	private MpApi mpApi;

	public MpUserApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 创建用户标签
	 * 
	 * @param name
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public TagsCreateResp apiTagsCreate(String name)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/create?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> tag = new TreeMap<String, Object>();
		tag.put("name", name);
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("tag", tag);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		TagsCreateResp resp = new Gson().fromJson(respText, TagsCreateResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagsCreate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取公众号已创建的标签
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public TagsGetResp apiTagsGet()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/get?access_token=%s", token.getAccessToken());
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		TagsGetResp resp = new Gson().fromJson(respText, TagsGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagsGet %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取用户身上的标签列表
	 * 
	 * @param openid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public TagsGetIdListResp apiTagsGetIdList(String openid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/getidlist?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> tag = new TreeMap<String, Object>();
		tag.put("openid", openid);
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("tag", tag);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		TagsGetIdListResp resp = new Gson().fromJson(respText, TagsGetIdListResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagsGetIdList %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 更新标签
	 * 
	 * @param name
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTagsUpdate(int id, String name)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/update?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> tag = new TreeMap<String, Object>();
		tag.put("id", id);
		tag.put("name", name);
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("tag", tag);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagsUpdate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 删除标签
	 * 
	 * @param id
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTagsDelete(int id)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/delete?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> tag = new TreeMap<String, Object>();
		tag.put("id", id);
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("tag", tag);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagsDelete %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 批量为用户打标签
	 * 
	 * @param tagid
	 * @param openids
	 *            每次传入的openid列表个数不能超过50个
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTagsMembersBatchTagging(int tagid, String[] openids)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/members/batchtagging?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> tag = new TreeMap<String, Object>();
		tag.put("tagid", tagid);
		tag.put("openid_list", openids);
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("tag", tag);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagsMembersBatchTagging %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 批量为用户取消标签
	 * 
	 * @param tagid
	 * @param openids
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTagsMembersBatchUnTagging(int tagid, String[] openids)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/members/batchtagging?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> tag = new TreeMap<String, Object>();
		tag.put("tagid", tagid);
		tag.put("openid_list", openids);
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("tag", tag);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagsMembersBatchUnTagging %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取黑名单用户列表
	 * 
	 * @param nextOpenid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public UserGetResp apiTagMembersGetBlacklist(String nextOpenid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/members/getblacklist?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_openid", nextOpenid);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		UserGetResp resp = new Gson().fromJson(respText, UserGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagMembersGetBlacklist %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 拉黑用户
	 * 
	 * @param openids
	 *            一次拉黑最多允许20个
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTagMembersBatchBlacklist(String[] openids)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/members/batchblacklist?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("openid_list", openids);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagMembersBatchBlacklist %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 取消拉黑用户
	 * 
	 * @param openids
	 *            一次最多允许20个
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTagMembersBatchUnBlacklist(String[] openids)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/tags/members/batchunblacklist?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("openid_list", openids);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTagMembersBatchUnBlacklist %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 根据标签取用户列表
	 * 
	 * @param tagid
	 * @param nextOpenid
	 *            第一个拉取的OPENID，不填默认从头开始拉取
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public UserGetResp apiUserTagGet(int tagid, String nextOpenid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/user/tag/get?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> tag = new TreeMap<String, Object>();
		tag.put("id", tagid);
		tag.put("next_openid", nextOpenid);
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("tag", tag);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		UserGetResp resp = new Gson().fromJson(respText, UserGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiUserTagGet %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取用户列表
	 * 
	 * @param nextOpenid
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public UserGetResp apiUserGet(String nextOpenid)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/user/get?access_token=%s&next_openid=%s", token, nextOpenid);
	
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		UserGetResp resp = new Gson().fromJson(respText, UserGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiUserGet %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 设置用户备注名
	 * 
	 * @param openid
	 * @param remark
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiUserInfoUpdateRemark(String openid, String remark)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/user/info/updateremark?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("openid", openid);
		reqMap.put("remark", remark);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiUserInfoUpdateRemark %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取用户基本信息（包括UnionID机制）
	 * 
	 * @param openid
	 * @param lang
	 *            返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public UserInfoResp apiUserInfo(String openid, LangEnum lang)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/user/info?access_token=%s&openid=%s&lang=%s", token, openid, lang);
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		UserInfoResp resp = new Gson().fromJson(respText, UserInfoResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiUserInfo %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 批量获取用户基本信息
	 * 
	 * @param openids
	 * @param lang
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public UserInfoBatchGetResp apiUserInfoBatchGet(String[] openids, LangEnum lang)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/user/info/batchget?access_token=%s", token.getAccessToken());
	
		int index = 0;
		Object[] users = new Object[openids.length];
		for (String openid : openids) {
			TreeMap<String, String> user = new TreeMap<String, String>();
			user.put("openid", openid);
			user.put("lang", lang.toString());
			users[index] = user;
			index++;
		}
	
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("user_list", users);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		UserInfoBatchGetResp resp = new Gson().fromJson(respText, UserInfoBatchGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiUserInfoBatchGet %s", new Gson().toJson(resp)));
		}
		return resp;
	}
}
