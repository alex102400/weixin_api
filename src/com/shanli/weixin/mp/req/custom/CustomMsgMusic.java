package com.shanli.weixin.mp.req.custom;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 音乐消息
 * 
 * @author alex
 *
 */
public class CustomMsgMusic extends CustomMsg {
	private Music music = new Music();

	public CustomMsgMusic(String touser,String title, String description, String musicurl, String hqmusicurl, String thumbMediaId) {
		super(touser,MediaTypeEnum.music);
		
		music.title = title;
		music.description = description;
		music.musicurl = musicurl;
		music.hqmusicurl = hqmusicurl;
		music.thumbMediaId = thumbMediaId;
	}

	public static class Music {
		private String title;
		private String description;
		private String musicurl;
		private String hqmusicurl;
		@SerializedName("thumb_media_id")
		private String thumbMediaId;

		public Music() {
			super();
		}

		public Music(String title, String description, String musicurl, String hqmusicurl, String thumbMediaId) {
			super();
			this.title = title;
			this.description = description;
			this.musicurl = musicurl;
			this.hqmusicurl = hqmusicurl;
			this.thumbMediaId = thumbMediaId;
		}

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
		 * @return the musicurl
		 */
		public String getMusicurl() {
			return musicurl;
		}

		/**
		 * @param musicurl
		 *            the musicurl to set
		 */
		public void setMusicurl(String musicurl) {
			this.musicurl = musicurl;
		}

		/**
		 * @return the hqmusicurl
		 */
		public String getHqmusicurl() {
			return hqmusicurl;
		}

		/**
		 * @param hqmusicurl
		 *            the hqmusicurl to set
		 */
		public void setHqmusicurl(String hqmusicurl) {
			this.hqmusicurl = hqmusicurl;
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

	/**
	 * @return the music
	 */
	public Music getMusic() {
		return music;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(Music music) {
		this.music = music;
	}
}
