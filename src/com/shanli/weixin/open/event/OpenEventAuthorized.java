package com.shanli.weixin.open.event;

/**
 * 公众号授权事件和授权更新事件。
 * 
 * @author alex
 *
 */
public class OpenEventAuthorized extends OpenEventMpAuthBase {
	public OpenEventAuthorized() {
		this.setInfoType(OpenEventTypeEnum.authorized);
	}

	/**
	 * 授权码
	 */
	private String authorizationCode;
	/**
	 * 授权码有效期
	 */
	private Long authorizationCodeExpiredTime;

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public Long getAuthorizationCodeExpiredTime() {
		return authorizationCodeExpiredTime;
	}

	public void setAuthorizationCodeExpiredTime(Long authorizationCodeExpiredTime) {
		this.authorizationCodeExpiredTime = authorizationCodeExpiredTime;
	}

}
