package com.shanli.weixin.mp.resp.msg;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 获取设置的行业信息
 * 
 * @author alex
 *
 */
public class TemplateGetIndustryResp extends BaseResp {
	@SerializedName("primary_industry")
	private Industry primaryIndustry;

	@SerializedName("secondary_industry")
	private Industry secondaryIndustry;

	public static class Industry {
		@SerializedName("first_class")
		private String firstClass;

		@SerializedName("second_class")
		private String secondClass;

		/**
		 * @return the firstClass
		 */
		public String getFirstClass() {
			return firstClass;
		}

		/**
		 * @param firstClass
		 *            the firstClass to set
		 */
		public void setFirstClass(String firstClass) {
			this.firstClass = firstClass;
		}

		/**
		 * @return the secondClass
		 */
		public String getSecondClass() {
			return secondClass;
		}

		/**
		 * @param secondClass
		 *            the secondClass to set
		 */
		public void setSecondClass(String secondClass) {
			this.secondClass = secondClass;
		}

	}

	/**
	 * @return the primaryIndustry
	 */
	public Industry getPrimaryIndustry() {
		return primaryIndustry;
	}

	/**
	 * @param primaryIndustry
	 *            the primaryIndustry to set
	 */
	public void setPrimaryIndustry(Industry primaryIndustry) {
		this.primaryIndustry = primaryIndustry;
	}

	/**
	 * @return the secondaryIndustry
	 */
	public Industry getSecondaryIndustry() {
		return secondaryIndustry;
	}

	/**
	 * @param secondaryIndustry
	 *            the secondaryIndustry to set
	 */
	public void setSecondaryIndustry(Industry secondaryIndustry) {
		this.secondaryIndustry = secondaryIndustry;
	}
}
