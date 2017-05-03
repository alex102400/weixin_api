package com.shanli.weixin.mp.req.mass;

import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 群发视频消息
 * 
 * @author alex
 *
 */
public class MassMsgMpVideo extends MassMsg {
	private MediaId mpvideo = new MediaId();

	public MassMsgMpVideo(String mediaId) {
		this.setMsgtype(MediaTypeEnum.mpvideo);
		mpvideo.setMediaId(mediaId);
	}

	/**
	 * @return the video
	 */
	public MediaId getMpVideo() {
		return mpvideo;
	}

	/**
	 * @param video
	 *            the video to set
	 */
	public void setMpVideo(MediaId video) {
		this.mpvideo = video;
	}

}
