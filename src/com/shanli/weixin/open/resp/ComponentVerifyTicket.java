package com.shanli.weixin.open.resp;

import com.shanli.weixin.bean.BaseExpires;

public class ComponentVerifyTicket extends BaseExpires {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6708690678351487685L;

	private String componentVerifyTicket;

	public ComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
		this.setExpiresIn(10 * 60);// 有效期10分钟。公众平台主动推送，不需要请求更新。
	}

	/**
	 * @return the componentVerifyTicket
	 */
	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}

	/**
	 * @param componentVerifyTicket
	 *            the componentVerifyTicket to set
	 */
	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}
}
