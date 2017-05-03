package com.shanli.weixin.mp.resp.msg;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 查询群发消息发送状态响应。
 * 
 * @author alex
 *
 */
public class MessageMassGetResp extends BaseResp {
	@SerializedName("msg_id")
	private String msgId;

	@SerializedName("msg_status")
	private String msgStatus;

	/**
	 * 消息发送任务的ID
	 * 
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * 消息发送任务的ID
	 * 
	 * @param msgId
	 *            the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * 消息发送后的状态，SEND_SUCCESS表示发送成功
	 * 
	 * @return the msgStatus
	 */
	public String getMsgStatus() {
		return msgStatus;
	}

	/**
	 * 消息发送后的状态，SEND_SUCCESS表示发送成功
	 * 
	 * @param msgStatus
	 *            the msgStatus to set
	 */
	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

}
