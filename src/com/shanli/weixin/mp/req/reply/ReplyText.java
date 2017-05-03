package com.shanli.weixin.mp.req.reply;

import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 回复文本
 * 
 * @author alex
 *
 */
public class ReplyText extends BaseReply {

	public ReplyText(UserMsg userMsg, String content) {
		super(userMsg, MediaTypeEnum.text);
		this.content = content;
	}

	private String content;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
