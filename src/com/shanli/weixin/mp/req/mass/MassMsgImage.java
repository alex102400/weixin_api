package com.shanli.weixin.mp.req.mass;

import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 图片消息
 * 
 * @author alex
 *
 */
public class MassMsgImage extends MassMsg {
	private MediaId image = new MediaId();

	public MassMsgImage(String mediaId) {
		this.setMsgtype(MediaTypeEnum.image);
		image.setMediaId(mediaId);
	}

	/**
	 * @return the image
	 */
	public MediaId getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(MediaId image) {
		this.image = image;
	}

}
