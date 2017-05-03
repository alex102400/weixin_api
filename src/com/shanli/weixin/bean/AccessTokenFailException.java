package com.shanli.weixin.bean;

/**
 * 令牌获取失败异常。对于公众号 AccessToken通常要求界面提醒用户重新授权。
 * 
 * @author alex
 *
 */
public class AccessTokenFailException extends Exception {

	public AccessTokenFailException(String msg) {
		super(msg);
	}

	public AccessTokenFailException(String msg, Exception e) {
		super(msg, e);
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8958357389043336446L;

}
