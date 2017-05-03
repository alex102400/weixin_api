package com.shanli.weixin.mp.recv.event;

/**
 * 模板消息发送完成事件。
 * 
 * @author alex
 *
 */
public class MsgEventTemplateSendJobjFinish extends MsgEvent {

	private String msgID;// 群发的消息ID
	/**
	 * 状态 success/failed:user block/failed: system failed
	 */
	private String status;//

	/**
	 * 状态
	 * 
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态
	 * 
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 群发的消息ID
	 * 
	 * @return the msgID
	 */
	public String getMsgID() {
		return msgID;
	}

	/**
	 * 群发的消息ID
	 * 
	 * @param msgID
	 *            the msgID to set
	 */
	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}
}
