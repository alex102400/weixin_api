package com.shanli.weixin.mp;

import java.util.Hashtable;

import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.bean.Ticket;
import com.shanli.weixin.mp.bean.TicketTypeEnum;

/**
 * 公众号运行时对象。主要包括accessToken/ticket等
 * 
 * @author alex
 *
 */
public class MpApiRuntime {
	private MpAccessToken accessToken;
	private Hashtable<TicketTypeEnum,Ticket> tickets=new Hashtable<TicketTypeEnum, Ticket>();

	/**
	 * @return the accessToken
	 */
	public MpAccessToken getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken
	 *            the accessToken to set
	 */
	public void setAccessToken(MpAccessToken accessToken) {
		this.accessToken = accessToken;
	}


	/**
	 * @return the tickets
	 */
	public Hashtable<TicketTypeEnum,Ticket> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(Hashtable<TicketTypeEnum,Ticket> tickets) {
		this.tickets = tickets;
	}

}
