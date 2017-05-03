package com.shanli.weixin.mp.req.custom;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 视频消息
 * 
 * @author alex
 *
 */
public class CustomMsgVideo extends CustomMsg {
	private Video video = new Video();

	public CustomMsgVideo(String touser,String mediaId, String title, String description, String thumbMediaId) {
		super(touser,MediaTypeEnum.video);
		video.setMediaId(mediaId);
		video.title = title;
		video.description = description;
		video.thumbMediaId = thumbMediaId;
	}

	/**
	 * @return the video
	 */
	public Video getVideo() {
		return video;
	}

	/**
	 * @param video
	 *            the video to set
	 */
	public void setVideo(Video video) {
		this.video = video;
	}

	public static class Video extends MediaId {
		private String title;
		private String description;
		@SerializedName("thumb_media_id")
		private String thumbMediaId;

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the thumbMediaId
		 */
		public String getThumbMediaId() {
			return thumbMediaId;
		}

		/**
		 * @param thumbMediaId
		 *            the thumbMediaId to set
		 */
		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}

	}
}
