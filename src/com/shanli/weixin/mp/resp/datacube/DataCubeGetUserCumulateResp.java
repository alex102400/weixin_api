package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 用户累计总量
 * 
 * @author alex
 *
 */
public class DataCubeGetUserCumulateResp extends BaseResp {
	private UserCumulate[] list;

	public static class UserCumulate {
		@SerializedName("ref_date")
		private String refDate;
		@SerializedName("cumulate_user")
		private Integer cumulateUser;

		/**
		 * 数据的日期
		 * 
		 * @return the refDate
		 */
		public String getRefDate() {
			return refDate;
		}

		/**
		 * 数据的日期
		 * 
		 * @param refDate
		 *            the refDate to set
		 */
		public void setRefDate(String refDate) {
			this.refDate = refDate;
		}

		/**
		 * 累计用户数
		 * 
		 * @return the cumulateUser
		 */
		public Integer getCumulateUser() {
			return cumulateUser;
		}

		/**
		 * 累计用户数
		 * 
		 * @param cumulateUser
		 *            the cumulateUser to set
		 */
		public void setCumulateUser(Integer cumulateUser) {
			this.cumulateUser = cumulateUser;
		}

	}

	/**
	 * @return the list
	 */
	public UserCumulate[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(UserCumulate[] list) {
		this.list = list;
	}
}
