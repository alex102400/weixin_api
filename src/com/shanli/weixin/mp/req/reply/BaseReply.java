package com.shanli.weixin.mp.req.reply;

import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 被动回复消息基类。
 * 
 * @author alex
 *
 */
public class BaseReply {
	private String toUserName;
	private String fromUserName;
	private int createTime;
	private MediaTypeEnum msgType;

	/**
	 * 
	 * @param userMsg
	 * @param msgType
	 */
	public BaseReply(UserMsg userMsg, MediaTypeEnum msgType) {
		this.toUserName = userMsg.getFromUserName();
		this.fromUserName = userMsg.getToUserName();
		this.createTime = (int) (System.currentTimeMillis() / 1000);
		this.msgType = msgType;
	}

	/**
	 * 接收方帐号（收到的OpenID）
	 * 
	 * @return the toUserName
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * 接收方帐号（收到的OpenID）
	 * 
	 * @param toUserName
	 *            the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * 开发者微信号
	 * 
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * 开发者微信号
	 * 
	 * @param fromUserName
	 *            the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * 消息创建时间 （整型）
	 * 
	 * @return the createTime
	 */
	public int getCreateTime() {
		return createTime;
	}

	/**
	 * 消息创建时间 （整型）
	 * 
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the msgType
	 */
	public MediaTypeEnum getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType
	 *            the msgType to set
	 */
	public void setMsgType(MediaTypeEnum msgType) {
		this.msgType = msgType;
	}

}
