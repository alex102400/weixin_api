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

	/**
	 * 授权公众号ID。只有api_query_auth才有
	 */
	@SerializedName("authorizer_appid")
	private String authorizerAppid;

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
	 * 授权公众号ID。已经做了处理，不仅api_query_auth有api_authorizer_token也会有。
	 * @return the authorizerAppid
	 */
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	/**
	 * 授权公众号ID。已经做了处理，不仅api_query_auth有api_authorizer_token也会有。
	 * @param authorizerAppid
	 *            the authorizerAppid to set
	 */
	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

}
