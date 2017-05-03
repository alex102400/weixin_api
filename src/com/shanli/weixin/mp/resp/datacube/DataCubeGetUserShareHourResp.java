package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 图文分享转发小时数据
 * 
 * @author alex
 *
 */
public class DataCubeGetUserShareHourResp extends BaseResp {
	private UserShareHour[] list;

	public static class UserShareHour extends UserShareCount {
		@SerializedName("ref_hour")
		private Integer refHour;

		/**
		 * @return the refHour
		 */
		public Integer getRefHour() {
			return refHour;
		}

		/**
		 * @param refHour
		 *            the refHour to set
		 */
		public void setRefHour(Integer refHour) {
			this.refHour = refHour;
		}
	}

	/**
	 * @return the list
	 */
	public UserShareHour[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(UserShareHour[] list) {
		this.list = list;
	}
}
