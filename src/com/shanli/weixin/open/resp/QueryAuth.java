package com.shanli.weixin.open.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 公众号的接口调用凭据和授权信息。由于此时返回的func_info不准确，因此不进行解析，可以通过api_get_authorizer_info获得精准的授权信息。
 * 
 * @author alex
 *
 */
public class QueryAuth extends BaseResp{

	@SerializedName("authorization_info")
	private AuthorizerAccessToken authorizationInfo;

	/**
	 * 授权方令牌信息
	 * 
	 * @return
	 */
	public AuthorizerAccessToken getAuthorizationInfo() {
		return authorizationInfo;
	}

	/**
	 * 授权方令牌信息
	 * 
	 * @param authorizationInfo
	 */
	public void setAuthorizationInfo(AuthorizerAccessToken authorizationInfo) {
		this.authorizationInfo = authorizationInfo;
	}

}
