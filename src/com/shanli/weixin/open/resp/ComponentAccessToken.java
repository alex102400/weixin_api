package com.shanli.weixin.open.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseExpires;

/**
 * 开放平台访问令牌。有效期默认2小时，需要使用ticket/seret/appid获取。
 * 
 * @author alex
 *
 */
public class ComponentAccessToken extends BaseExpires {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1074535775589370342L;

	/**
	 * 访问令牌
	 */
	@SerializedName("component_access_token")
	private String componentAccessToken;

	public String getComponentAccessToken() {
		return componentAccessToken;
	}

	public void setComponentAccessToken(String componentAccessToken) {
		this.componentAccessToken = componentAccessToken;
	}

}
