package com.shanli.weixin.mp.resp.cs;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 客户会话状态
 * 
 * @author alex
 *
 */
public class GetSessionResp extends BaseResp {
	private Long createtime;
	@SerializedName("kf_account")
	private String kfAccount;

	/**
	 * @return the createtime
	 */
	public Long getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	/**
	 * 正在接待的客服，为空表示没有人在接待
	 * 
	 * @return the kfAccount
	 */
	public String getKfAccount() {
		return kfAccount;
	}

	/**
	 * 正在接待的客服，为空表示没有人在接待
	 * 
	 * @param kfAccount
	 *            the kfAccount to set
	 */
	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}

}
