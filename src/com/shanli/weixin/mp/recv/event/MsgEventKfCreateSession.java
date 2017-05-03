package com.shanli.weixin.mp.recv.event;
/**
 * 客服会话创建
 * @author alex
 *
 */
public class MsgEventKfCreateSession extends MsgEvent {
	private String kfAccount;

	/**
	 * @return the kfAccount
	 */
	public String getKfAccount() {
		return kfAccount;
	}

	/**
	 * @param kfAccount the kfAccount to set
	 */
	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}
	
}
