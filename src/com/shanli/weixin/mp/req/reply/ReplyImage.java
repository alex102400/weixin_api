package com.shanli.weixin.mp.req.reply;

import com.shanli.weixin.mp.bean.MediaId;
import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 回复图片
 * 
 * @author alex
 *
 */
public class ReplyImage extends BaseReply {
	private MediaId image = new MediaId();

	public ReplyImage(UserMsg userMsg, String mediaId) {
		super(userMsg, MediaTypeEnum.image);
		this.image.setMediaId(mediaId);
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
