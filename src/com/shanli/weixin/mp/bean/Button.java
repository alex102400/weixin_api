package com.shanli.weixin.mp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 菜单按钮
 * 
 * @author alex
 *
 */
public class Button {
	/**
	 * 菜单的响应动作类型
	 */
	private String type;

	/**
	 * 菜单标题，不超过16个字节，子菜单不超过60个字节
	 */
	private String name;

	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节。click等点击类型必须
	 */
	private String key;

	/**
	 * 网页链接，用户点击菜单可打开链接，不超过1024字节。view类型必须
	 */
	private String url;

	/**
	 * 调用新增永久素材接口返回的合法media_id。media_id类型和view_limited类型必须
	 */
	@SerializedName("media_id")
	private String mediaId;

	/**
	 * 二级菜单数组，个数应为1~5个
	 */
	@SerializedName("sub_button")
	private Button[] subButton;

	/**
	 * 菜单的响应动作类型
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 菜单的响应动作类型
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 菜单标题，不超过16个字节，子菜单不超过60个字节
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 菜单标题，不超过16个字节，子菜单不超过60个字节
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节。click等点击类型必须
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节。click等点击类型必须
	 * 
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 网页链接，用户点击菜单可打开链接，不超过1024字节。view类型必须
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 网页链接，用户点击菜单可打开链接，不超过1024字节。view类型必须
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 调用新增永久素材接口返回的合法media_id。media_id类型和view_limited类型必须
	 * 
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 调用新增永久素材接口返回的合法media_id。media_id类型和view_limited类型必须
	 * 
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * 二级菜单数组，个数应为1~5个
	 * 
	 * @return the subButton
	 */
	public Button[] getSubButton() {
		return subButton;
	}

	/**
	 * 二级菜单数组，个数应为1~5个
	 * 
	 * @param subButton
	 *            the subButton to set
	 */
	public void setSubButton(Button[] subButton) {
		this.subButton = subButton;
	}

}
