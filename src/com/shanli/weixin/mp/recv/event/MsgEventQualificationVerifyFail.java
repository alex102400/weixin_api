package com.shanli.weixin.mp.recv.event;

/**
 * 资质认证失败
 * @author alex
 *
 */
public class MsgEventQualificationVerifyFail extends MsgEvent {
	private Integer failTime;
	private String failReason;

	/**
	 * 失败发生时间
	 * 
	 * @return the failTime
	 */
	public Integer getFailTime() {
		return failTime;
	}

	/**
	 * 失败发生时间
	 * 
	 * @param failTime
	 *            the failTime to set
	 */
	public void setFailTime(Integer failTime) {
		this.failTime = failTime;
	}

	/**
	 * 认证失败的原因
	 * 
	 * @return the failReason
	 */
	public String getFailReason() {
		return failReason;
	}

	/**
	 * 认证失败的原因
	 * 
	 * @param failReason
	 *            the failReason to set
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

}
