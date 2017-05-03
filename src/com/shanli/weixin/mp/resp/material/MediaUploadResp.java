package com.shanli.weixin.mp.resp.material;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 上传图文消息素材
 * 
 * @author alex
 *
 */
public class MediaUploadResp extends BaseResp {
	private String type;// 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
	@SerializedName("media_id")
	private String mediaId;// 媒体文件/图文消息上传后获取的唯一标识
	@SerializedName("created_at")
	private Long createdAt;// 媒体文件上传时间

	private String url;// 图片素材的url

	/**
	 * 临时素材的类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 临时素材的类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 媒体文件/图文消息上传后获取的唯一标识
	 * 
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 媒体文件/图文消息上传后获取的唯一标识
	 * 
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * 临时素材上传时间
	 * 
	 * @return the createdAt
	 */
	public Long getCreatedAt() {
		return createdAt;
	}

	/**
	 * 临时素材上传时间
	 * 
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * 图片素材的url
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 图片素材的url
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
