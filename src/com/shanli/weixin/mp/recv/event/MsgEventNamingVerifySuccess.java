package com.shanli.weixin.mp.recv.event;
/**
 * 名称认证成功（即命名成功）
 * @author alex
 *
 */
public class MsgEventNamingVerifySuccess extends MsgEvent {
	private Integer expiredTime;// 有效期 时间戳，将于该时间戳认证过期
	/**
	 * 有效期时间戳，将于该时间戳认证过期
	 * 
	 * @return the expiredTime
	 */
	public Integer getExpiredTime() {
		return expiredTime;
	}

	/**
	 * 有效期时间戳，将于该时间戳认证过期
	 * 
	 * @param expiredTime
	 *            the expiredTime to set
	 */
	public void setExpiredTime(Integer expiredTime) {
		this.expiredTime = expiredTime;
	}

}
