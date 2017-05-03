package com.shanli.weixin.open.event;

/**
 * 公众号授权/更新/取消授权事件基类。
 * 
 * @author alex
 *
 */
public class OpenEventMpAuthBase extends OpenEvent {
	private String authorizerAppid;

	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

}
