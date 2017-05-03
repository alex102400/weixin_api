package com.shanli.weixin.open.event;

/**
 * Ticket事件。
 * 
 * @author alex
 *
 */
public class OpenEventTicket extends OpenEvent {
	private String componentVerifyTicket;


	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}

	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}

}
