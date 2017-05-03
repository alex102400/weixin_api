package com.shanli.weixin.mp.recv;

import com.shanli.weixin.mp.recv.event.MsgEvent;

/**
 * 消息Enum
 * 
 * @author alex
 *
 */
public enum UserMsgTypeEnum {
	/**
	 * 文本消息
	 */
	text(UserMsgText.class),
	/**
	 * 图片消息
	 */
	image(UserMsgImage.class),
	/**
	 * 链接消息
	 */
	link(UserMsgLink.class),
	/**
	 * 语音消息
	 */
	voice(UserMsgVoice.class),
	/**
	 * 视频消息
	 */
	video(UserMsgVideo.class),
	/**
	 * 位置消息
	 */
	location(UserMsgLocation.class),
	/**
	 * 事件消息
	 */
	event(MsgEvent.class);

	private Class<? extends UserMsg> clazz;

	/**
	 * 实现类。
	 * 
	 * @return
	 */
	public Class<? extends UserMsg> getClazz() {
		return this.clazz;
	}

	private UserMsgTypeEnum(Class<? extends UserMsg> clazz) {
		this.clazz = clazz;
	}

}
