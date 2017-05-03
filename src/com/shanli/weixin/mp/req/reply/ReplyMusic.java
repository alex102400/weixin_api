package com.shanli.weixin.mp.req.reply;

import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 回复音乐
 * 
 * @author alex
 *
 */
public class ReplyMusic extends BaseReply {
	private Music music;

	public ReplyMusic(UserMsg userMsg, String title, String description, String musicUrl, String hQMusicUrl,
			String thumbMediaId) {
		super(userMsg, MediaTypeEnum.music);
		setMusic(new Music(title, description, musicUrl, hQMusicUrl, thumbMediaId));
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

	public static class Music {
		private String title;
		private String description;
		private String musicUrl;
		private String hQMusicUrl;
		private String thumbMediaId;

		public Music(String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId) {
			super();
			this.title = title;
			this.description = description;
			this.musicUrl = musicUrl;
			this.hQMusicUrl = hQMusicUrl;
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
		 * @return the musicUrl
		 */
		public String getMusicUrl() {
			return musicUrl;
		}

		/**
		 * @param musicUrl
		 *            the musicUrl to set
		 */
		public void setMusicUrl(String musicUrl) {
			this.musicUrl = musicUrl;
		}

		/**
		 * @return the hQMusicUrl
		 */
		public String gethQMusicUrl() {
			return hQMusicUrl;
		}

		/**
		 * @param hQMusicUrl
		 *            the hQMusicUrl to set
		 */
		public void sethQMusicUrl(String hQMusicUrl) {
			this.hQMusicUrl = hQMusicUrl;
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
