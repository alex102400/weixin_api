package com.shanli.weixin.open.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 微信用户网页授权AccessToken
 * 
 * @author alex
 *
 */
public class OAuthAccessToken extends BaseResp {

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("refresh_token")
	private String refreshToken;

	private String openid;

	private String scope;

	/**
	 * 调用凭证
	 * 
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * 调用凭证
	 * 
	 * @param accessToken
	 *            the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 刷新凭证
	 * 
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * 刷新凭证
	 * 
	 * @param refreshToken
	 *            the refreshToken to set
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	/**
	 * 授权用户唯一标识
	 * 
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 授权用户唯一标识
	 * 
	 * @param openid
	 *            the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 * 
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 * 
	 * @param scope
	 *            the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

}
