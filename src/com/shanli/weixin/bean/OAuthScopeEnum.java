package com.shanli.weixin.bean;

/**
 * 微信网页授权类型
 * 
 * @author alex
 *
 */
public enum OAuthScopeEnum {
	/**
	 * 获取用户openid。静默授权自动跳转到回调页。
	 */
	snsapi_base,
	/**
	 * 获取用户基本信息。用户手动同意后跳转到回调页。
	 */
	snsapi_userinfo
}
