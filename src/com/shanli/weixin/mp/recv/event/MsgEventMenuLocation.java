package com.shanli.weixin.mp.recv.event;

import com.shanli.weixin.mp.recv.UserMsgLocation;

/**
 * 弹出地理位置选择器的事件
 * 
 * @author alex
 *
 */
public class MsgEventMenuLocation extends MsgEventMenuClick {
	private UserMsgLocation sendLocationInfo;

	/**
	 * @return the sendLocationInfo
	 */
	public UserMsgLocation getSendLocationInfo() {
		return sendLocationInfo;
	}

	/**
	 * @param sendLocationInfo
	 *            the sendLocationInfo to set
	 */
	public void setSendLocationInfo(UserMsgLocation sendLocationInfo) {
		this.sendLocationInfo = sendLocationInfo;
	}

}
