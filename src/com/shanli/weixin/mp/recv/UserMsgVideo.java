package com.shanli.weixin.mp.recv;

/**
 * 视频消息
 * 
 * @author alex
 *
 */
public class UserMsgVideo extends UserMsg {

	/**
	 * 媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;

	/**
	 * 缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String thumbMediaId;

	/**
	 * 媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * 缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @return the thumbMediaId
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	/**
	 * 缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @param thumbMediaId
	 *            the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

}
