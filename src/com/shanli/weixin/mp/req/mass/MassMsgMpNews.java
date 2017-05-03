package com.shanli.weixin.mp.req.mass;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 群发发送图文消息
 * 
 * @author alex
 *
 */
public class MassMsgMpNews extends MassMsg {
	@SerializedName("send_ignore_reprint")
	private Integer sendIgnoreReprint = 0;// 文章被判定为转载时，是否继续群发。

	private MediaId mpnews = new MediaId();

	public MassMsgMpNews(String mediaId) {
		this.setMsgtype(MediaTypeEnum.mpnews);
		mpnews.setMediaId(mediaId);
	}

	/**
	 * @return the mpnews
	 */
	public MediaId getMpnews() {
		return mpnews;
	}

	/**
	 * @param mpnews
	 *            the mpnews to set
	 */
	public void setMpnews(MediaId mpnews) {
		this.mpnews = mpnews;
	}

	/**
	 * @return the sendIgnoreReprint
	 */
	public Integer getSendIgnoreReprint() {
		return sendIgnoreReprint;
	}

	/**
	 * @param sendIgnoreReprint
	 *            the sendIgnoreReprint to set
	 */
	public void setSendIgnoreReprint(Integer sendIgnoreReprint) {
		this.sendIgnoreReprint = sendIgnoreReprint;
	}
}
