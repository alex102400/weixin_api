package com.shanli.weixin.mp.req.custom;

import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 文本消息
 * 
 * @author alex
 *
 */
public class CustomMsgText extends CustomMsg {
	private TextContent text = new TextContent();

	public CustomMsgText(String touser,String content) {
		super(touser,MediaTypeEnum.text);
		this.text.setContent(content);
	}

	public static class TextContent {
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

	/**
	 * @return the text
	 */
	public TextContent getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(TextContent text) {
		this.text = text;
	}

}
