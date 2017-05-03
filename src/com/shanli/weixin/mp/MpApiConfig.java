package com.shanli.weixin.mp;

import com.shanli.weixin.WeixinConfig;

/**
 * 公众号配置参数。
 * 
 * @author alex
 *
 */
public class MpApiConfig extends WeixinConfig {
	private String appId;
	private String appSecret;
	private String appToken;
	private String appEncodingAESKey;
	private boolean openMode;

	/**
	 * 创建基于开放平台的配置对象。不需要指定secret、token、aeskey参数。
	 * 
	 * @param appId
	 *           公众号appid
	 */
	public MpApiConfig(String appId) {
		openMode = true;
		this.appId = appId;
	}

	/**
	 * 创建公众平台开发模式配置对象。
	 * 
	 * @param appId
	 * @param appSecret
	 * @param appToken
	 * @param appEncodingAESKey
	 */
	public MpApiConfig(String appId, String appSecret, String appToken, String appEncodingAESKey) {
		openMode = false;
		this.appId = appId;
		this.appSecret = appSecret;
		this.appToken = appToken;
		this.appEncodingAESKey = appEncodingAESKey;
	}

	/**
	 * 是否基于开放平台
	 * 
	 * @return
	 */
	public boolean isOpenMode() {
		return openMode;
	}

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId
	 *            the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return the appSecret
	 */
	public String getAppSecret() {
		return appSecret;
	}

	/**
	 * @param appSecret
	 *            the appSecret to set
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	/**
	 * @return the appToken
	 */
	public String getAppToken() {
		return appToken;
	}

	/**
	 * @param appToken
	 *            the appToken to set
	 */
	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	/**
	 * @return the appEncodingAESKey
	 */
	public String getAppEncodingAESKey() {
		return appEncodingAESKey;
	}

	/**
	 * @param appEncodingAESKey
	 *            the appEncodingAESKey to set
	 */
	public void setAppEncodingAESKey(String appEncodingAESKey) {
		this.appEncodingAESKey = appEncodingAESKey;
	}

	

}
