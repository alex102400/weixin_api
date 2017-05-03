package com.shanli.weixin;

import com.google.gson.Gson;

/**
 * 微信平台通用配置。
 * 
 * @author alex
 *
 */
public class WeixinConfig {
	/**
	 * 微信平台HTTPS接口URL
	 */
	private String apiHttps = "https://api.weixin.qq.com/cgi-bin";

	/**
	 * 微信平台HTTP接口URL
	 */
	private String apiHttp = "http://api.weixin.qq.com/cgi-bin";

	/**
	 * 网页OAuth授权接口URL
	 */
	private String apiOAuth = "https://api.weixin.qq.com/sns";

	/**
	 * 微信平台HTTPS接口URL。默认"https://api.weixin.qq.com/cgi-bin"
	 * 
	 * @return the apiHttpsUrl
	 */
	public String getApiHttps() {
		return apiHttps;
	}

	/**
	 * 微信平台HTTPS接口URL。默认"https://api.weixin.qq.com/cgi-bin"
	 * 
	 * @param apiHttps
	 *            the apiHttps to set
	 */
	public void setApiHttps(String apiHttps) {
		this.apiHttps = apiHttps;
	}

	/**
	 * 微信平台HTTP接口URL。默认"http://api.weixin.qq.com/cgi-bin"
	 * 
	 * @return the apiHttp
	 */
	public String getApiHttp() {
		return apiHttp;
	}

	/**
	 * 微信平台HTTP接口URL。默认"http://api.weixin.qq.com/cgi-bin"
	 * 
	 * @param apiHttp
	 *            the apiHttpUrl to set
	 */
	public void setApiHttp(String apiHttp) {
		this.apiHttp = apiHttp;
	}

	/**
	 * 网页OAuth授权接口URL。默认"https://api.weixin.qq.com/sns"
	 * 
	 * @return the apiOAuth
	 */
	public String getApiOAuth() {
		return apiOAuth;
	}

	/**
	 * 网页OAuth授权接口URL。默认"https://api.weixin.qq.com/sns"
	 * 
	 * @param apiOAuth
	 *            the apiOAuth to set
	 */
	public void setApiOAuth(String apiOAuth) {
		this.apiOAuth = apiOAuth;
	}

	private String encryptNonce = "ahsllsh";//

	/**
	 * 用于加密被动回复消息的随机字段串
	 * 
	 * @return the encryptNonce
	 */
	public String getEncryptNonce() {
		return encryptNonce;
	}

	/**
	 * 用于加密被动回复消息的随机字段串
	 * 
	 * @param encryptNonce
	 *            the encryptNonce to set
	 */
	public void setEncryptNonce(String encryptNonce) {
		this.encryptNonce = encryptNonce;
	}

	/*
	 * 转换为json字符串
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
