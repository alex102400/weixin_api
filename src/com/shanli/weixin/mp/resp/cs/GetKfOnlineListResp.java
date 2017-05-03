package com.shanli.weixin.mp.resp.cs;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 在线客服
 * 
 * @author alex
 *
 */
public class GetKfOnlineListResp extends BaseResp {
	@SerializedName("kf_online_list")
	private KfAccountOnline[] kfOnlineList;

	public static class KfAccountOnline extends ServiceAccount {

		private Integer status;
		@SerializedName("accepted_case")
		private Integer acceptedCase;

		/**
		 * 客服在线状态，目前为：1、web 在线
		 * 
		 * @return the status
		 */
		public Integer getStatus() {
			return status;
		}

		/**
		 * 客服在线状态，目前为：1、web 在线
		 * 
		 * @param status
		 *            the status to set
		 */
		public void setStatus(Integer status) {
			this.status = status;
		}

		/**
		 * 客服当前正在接待的会话数
		 * 
		 * @return the acceptedCase
		 */
		public Integer getAcceptedCase() {
			return acceptedCase;
		}

		/**
		 * 客服当前正在接待的会话数
		 * 
		 * @param acceptedCase
		 *            the acceptedCase to set
		 */
		public void setAcceptedCase(Integer acceptedCase) {
			this.acceptedCase = acceptedCase;
		}

	}

	/**
	 * @return the kfList
	 */
	public KfAccountOnline[] getKfList() {
		return kfOnlineList;
	}

	/**
	 * @param kfList
	 *            the kfList to set
	 */
	public void setKfList(KfAccountOnline[] kfList) {
		this.kfOnlineList = kfList;
	}

}
