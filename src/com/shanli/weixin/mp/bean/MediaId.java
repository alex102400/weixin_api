package com.shanli.weixin.mp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 图片/语音等消息中使用的MediaId
 * 
 * @author alex
 *
 */
public class MediaId {
	@SerializedName("media_id")
	private String mediaId;

	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
