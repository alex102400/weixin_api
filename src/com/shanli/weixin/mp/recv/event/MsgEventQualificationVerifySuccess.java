package com.shanli.weixin.mp.recv.event;

/**
 * 资质认证成功（此时立即获得接口权限）
 * 
 * @author alex
 *
 */
public class MsgEventQualificationVerifySuccess extends MsgEvent {
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
