package com.shanli.weixin.mp.req.reply;

import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 回复视频
 * 
 * @author alex
 *
 */
public class ReplyVideo extends BaseReply {
	private Video video = new Video();

	public ReplyVideo(UserMsg userMsg, String mediaId, String title, String desc) {
		super(userMsg, MediaTypeEnum.video);
		this.video.setMediaId(mediaId);
		this.video.title=title;
		this.video.description=desc;
	}
	
	public static class Video extends MediaId{
		private String title;
		private String description;
		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * @param title the title to set
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
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}


}
