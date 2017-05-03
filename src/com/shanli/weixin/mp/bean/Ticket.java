package com.shanli.weixin.mp.bean;

import com.shanli.weixin.bean.BaseExpires;
/**
 * Ticket。如jsapi_ticket。
 * @author alex
 *
 */
public class Ticket extends BaseExpires {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7119687866694480297L;
	
	private String ticket;

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
