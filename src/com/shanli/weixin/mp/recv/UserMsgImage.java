package com.shanli.weixin.mp.recv;

/**
 * 图片消息
 * 
 * @author alex
 *
 */
public class UserMsgImage extends UserMsg {
	/**
	 * 图片链接（由系统生成）
	 */
	private String picUrl;// 图片链接（由系统生成）
	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

	/**
	 * 图片链接（由系统生成）
	 *
	 *
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * 图片链接（由系统生成）
	 * 
	 * @param picUrl
	 *            the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
