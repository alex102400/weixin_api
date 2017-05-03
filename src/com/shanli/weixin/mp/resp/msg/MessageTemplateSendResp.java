package com.shanli.weixin.mp.resp.msg;

import com.shanli.weixin.bean.BaseResp;

/**
 * 模板消息发送响应
 * 
 * @author alex
 *
 */
public class MessageTemplateSendResp extends BaseResp {
	private String msgid;

	/**
	 * @return the msgid
	 */
	public String getMsgid() {
		return msgid;
	}

	/**
	 * @param msgid
	 *            the msgid to set
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
}
