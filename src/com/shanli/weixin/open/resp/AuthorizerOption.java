package com.shanli.weixin.open.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 授权方的选项设置信息
 * 
 * @author alex
 *
 */
public class AuthorizerOption  extends BaseResp{
	/**
	 * 授权公众号appid
	 */
	@SerializedName("authorizer_appid")
	private String authorizerAppid;

	/**
	 * 选项名称
	 */
	@SerializedName("option_name")
	private String optionName;

	/**
	 * 选项值
	 */
	@SerializedName("option_value")
	private String optionValue;

	/**
	 * 授权公众号appid
	 * 
	 * @return the authorizerAppid
	 */
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	/**
	 * 授权公众号appid
	 * 
	 * @param authorizerAppid
	 *            the authorizerAppid to set
	 */
	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	/**
	 * 选项名称
	 * 
	 * @return the optionName
	 */
	public String getOptionName() {
		return optionName;
	}

	/**
	 * 选项名称
	 * 
	 * @param optionName
	 *            the optionName to set
	 */
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	/**
	 * 选项值
	 * 
	 * @return the optionValue
	 */
	public String getOptionValue() {
		return optionValue;
	}

	/**
	 * 选项值
	 * 
	 * @param optionValue
	 *            the optionValue to set
	 */
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

}
