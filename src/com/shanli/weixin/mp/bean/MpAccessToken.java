package com.shanli.weixin.mp.bean;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseExpires;

/**
 * 访问令牌
 * 
 * @author alex
 *
 */
public class MpAccessToken extends BaseExpires {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1836590084073871740L;
	@SerializedName("access_token")
	private String accessToken;
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
