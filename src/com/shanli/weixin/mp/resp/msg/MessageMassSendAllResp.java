package com.shanli.weixin.mp.resp.msg;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 群发消息响应。
 * 在返回成功时，意味着群发任务提交成功，发送结果通过MASSSENDJOBFINISH事件回调。
 * 
 * @author alex
 *
 */
public class MessageMassSendAllResp extends BaseResp {
	@SerializedName("msg_id")
	private String msgId;

	/**
	 * 消息的数据ID，该字段只有在群发图文消息时，才会出现。 可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
	 * 是图文分析数据接口中的msgid字段中的前半部分， 详见图文分析数据接口中的msgid字段的介绍。
	 */
	@SerializedName("msg_data_id")
	private String msgDataId;

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
	 * 消息的数据ID，该字段只有在群发图文消息时，才会出现。
	 * 
	 * @return the msgDataId
	 */
	public String getMsgDataId() {
		return msgDataId;
	}

	/**
	 * 消息的数据ID，该字段只有在群发图文消息时，才会出现。
	 * 
	 * @param msgDataId
	 *            the msgDataId to set
	 */
	public void setMsgDataId(String msgDataId) {
		this.msgDataId = msgDataId;
	}

}
