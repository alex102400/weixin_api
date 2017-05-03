package com.shanli.weixin.open.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseExpires;

public class PreAuthCode extends BaseExpires {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2593586281911305557L;

	@SerializedName("pre_auth_code")
	private String preAuthCode;

	public String getPreAuthCode() {
		return preAuthCode;
	}

	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode = preAuthCode;
	}

}
