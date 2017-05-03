package com.shanli.weixin.mp.recv.event;

/**
 * 自定义菜单事件。 用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报。
 * 
 * @author alex
 *
 */
public class MsgEventMenuClick extends MsgEvent {
	private String eventKey;// 事件KEY值，与自定义菜单接口中KEY值对应

	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 * 
	 * @return the eventKey
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 * 
	 * @param eventKey
	 *            the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

}
