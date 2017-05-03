package com.shanli.weixin.mp.recv.event;

/**
 * 老用户扫码事件
 * 
 * @author alex
 *
 */
public class MsgEventScan extends MsgEvent {
	private String eventKey;// 事件KEY值，即创建二维码时的二维码scene_id
	private String ticket;// 二维码的ticket，可用来换取二维码图片

	/**
	 * 事件KEY值，事件KEY值，即创建二维码时的二维码scene_id
	 * 
	 * @return the eventKey
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * 事件KEY值，事件KEY值，即创建二维码时的二维码scene_id
	 * 
	 * @param eventKey
	 *            the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * 二维码的ticket，可用来换取二维码图片
	 * 
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * 二维码的ticket，可用来换取二维码图片
	 * 
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
