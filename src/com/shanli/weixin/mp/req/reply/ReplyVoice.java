package com.shanli.weixin.mp.req.reply;

import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 回复语音
 * 
 * @author alex
 *
 */
public class ReplyVoice extends BaseReply {
	private MediaId voice = new MediaId();

	public ReplyVoice(UserMsg userMsg, String mediaId) {
		super(userMsg, MediaTypeEnum.voice);
		this.voice.setMediaId(mediaId);
	}

	/**
	 * @return the voice
	 */
	public MediaId getVoice() {
		return voice;
	}

	/**
	 * @param voice
	 *            the voice to set
	 */
	public void setVoice(MediaId voice) {
		this.voice = voice;
	}

}
