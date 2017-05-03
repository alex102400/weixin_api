package com.shanli.weixin.mp.recv;

/**
 * 文本消息
 * 
 * @author alex
 *
 */
public class UserMsgText extends UserMsg {
	private String content;

	/**
	 * 文本消息内容
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 文本消息内容
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
