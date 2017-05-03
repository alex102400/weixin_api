package com.shanli.weixin.mp.resp.material;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 素材总数
 * 
 * @author alex
 *
 */
public class GetMaterialCountResp extends BaseResp {
	@SerializedName("voice_count")
	private Long voiceCount;

	@SerializedName("video_count")
	private Long videoCount;
	@SerializedName("image_count")
	private Long imageCount;
	@SerializedName("news_count")
	private Long newsCount;

	/**
	 * @return the voiceCount
	 */
	public Long getVoiceCount() {
		return voiceCount;
	}

	/**
	 * @param voiceCount
	 *            the voiceCount to set
	 */
	public void setVoiceCount(Long voiceCount) {
		this.voiceCount = voiceCount;
	}

	/**
	 * @return the videoCount
	 */
	public Long getVideoCount() {
		return videoCount;
	}

	/**
	 * @param videoCount
	 *            the videoCount to set
	 */
	public void setVideoCount(Long videoCount) {
		this.videoCount = videoCount;
	}

	/**
	 * @return the imageCount
	 */
	public Long getImageCount() {
		return imageCount;
	}

	/**
	 * @param imageCount
	 *            the imageCount to set
	 */
	public void setImageCount(Long imageCount) {
		this.imageCount = imageCount;
	}

	/**
	 * @return the newsCount
	 */
	public Long getNewsCount() {
		return newsCount;
	}

	/**
	 * @param newsCount
	 *            the newsCount to set
	 */
	public void setNewsCount(Long newsCount) {
		this.newsCount = newsCount;
	}

}
