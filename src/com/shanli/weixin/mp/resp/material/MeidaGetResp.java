package com.shanli.weixin.mp.resp.material;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

public class MeidaGetResp extends BaseResp {
	private String filename;// 原始文件名

	@SerializedName("video_url")
	private String videoUrl;// 视频URL

	/**
	 * 原始文件名
	 * 
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * 原始文件名
	 * 
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * 视频URL
	 * 
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * 视频URL
	 * 
	 * @param videoUrl
	 *            the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}
