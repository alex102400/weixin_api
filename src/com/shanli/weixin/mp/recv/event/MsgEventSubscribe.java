package com.shanli.weixin.mp.recv.event;

/**
 * 新用户订阅事件/扫码订阅事件
 * 
 * @author alex
 *
 */
public class MsgEventSubscribe extends MsgEvent {
	private String eventKey;// 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String ticket;// 二维码的ticket，可用来换取二维码图片

	/**
	 * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	 * 
	 * @return the eventKey
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
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
