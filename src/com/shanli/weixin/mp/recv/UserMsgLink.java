package com.shanli.weixin.mp.recv;

/**
 * 链接消息
 * 
 * @author alex
 *
 */
public class UserMsgLink extends UserMsg {
	private String title;// 消息标题
	private String description;// 消息描述
	private String url;// 消息链接

	/**
	 * 消息标题
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 消息标题
	 * 
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 消息描述
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 消息描述
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 消息链接
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 消息链接
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
