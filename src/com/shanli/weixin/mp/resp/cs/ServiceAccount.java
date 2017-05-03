package com.shanli.weixin.mp.resp.cs;

import com.google.gson.annotations.SerializedName;

/**
 * 客服账号
 * 
 * @author alex
 *
 */
public class ServiceAccount {
	@SerializedName("kf_account")
	private String kfAccount;
	@SerializedName("kf_id")
	private String kfId;

	/**
	 * 完整客服账号，格式为：账号前缀@公众号微信号
	 * 
	 * @return the kfAccount
	 */
	public String getKfAccount() {
		return kfAccount;
	}

	/**
	 * 完整客服账号，格式为：账号前缀@公众号微信号
	 * 
	 * @param kfAccount
	 *            the kfAccount to set
	 */
	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

	/**
	 * 客服工号
	 * 
	 * @return the kfId
	 */
	public String getKfId() {
		return kfId;
	}

	/**
	 * 客服工号
	 * 
	 * @param kfId
	 *            the kfId to set
	 */
	public void setKfId(String kfId) {
		this.kfId = kfId;
	}

}
