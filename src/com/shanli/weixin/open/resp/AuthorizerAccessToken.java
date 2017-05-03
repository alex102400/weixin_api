package com.shanli.weixin.open.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseExpires;

/**
 * 授权方令牌（authorizer_access_token）。
 * 
 * @author alex
 *
 */
public class AuthorizerAccessToken extends BaseExpires {

	/**
	 * serialVersionUID
	 * 
	 */
	private static final long serialVersionUID = -4966017237063412582L;

	private String mpAppid;

	@SerializedName("authorizer_access_token")
	private String authorizerAccessToken;

	@SerializedName("authorizer_refresh_token")
	private String authorizerRefreshToken;

	/**
	 * 授权方令牌
	 * 
	 * @return
	 */
	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}

	/**
	 * 授权方令牌
	 * 
	 * @param authorizerAccessToken
	 */
	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}

	/**
	 * 刷新令牌
	 * 
	 * @return
	 */
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}

	/**
	 * 刷新令牌
	 * 
	 * @param authorizerRefreshToken
	 */
	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}

	/**
	 * @return the mpAppid
	 */
	public String getMpAppid() {
		return mpAppid;
	}

	/**
	 * @param mpAppid
	 *            the mpAppid to set
	 */
	public void setMpAppid(String mpAppid) {
		this.mpAppid = mpAppid;
	}

}
