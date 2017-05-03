package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 接口分析数据
 * 
 * @author alex
 *
 */
public class DataCubeGetInterfaceSummaryHourResp extends BaseResp {
	private InterfaceSummaryHour[] list;

	public static class InterfaceSummaryHour extends InterfaceSummary {
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
	public InterfaceSummaryHour[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(InterfaceSummaryHour[] list) {
		this.list = list;
	}

}
