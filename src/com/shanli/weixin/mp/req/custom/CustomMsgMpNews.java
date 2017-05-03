package com.shanli.weixin.mp.req.custom;

import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 发送图文消息（点击跳转到图文消息页面） 图文消息条数限制在8条以内，注意，如果图文数超过8，则将会无响应。
 * 
 * @author alex
 *
 */
public class CustomMsgMpNews extends CustomMsg {
	private MediaId mpnews = new MediaId();

	public CustomMsgMpNews(String touser,String mediaId) {
		super(touser,MediaTypeEnum.mpnews);
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

}
