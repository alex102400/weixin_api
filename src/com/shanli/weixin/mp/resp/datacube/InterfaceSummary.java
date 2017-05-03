package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;

/**
 * 接口统计
 * 
 * @author alex
 *
 */
public class InterfaceSummary {
	@SerializedName("ref_date")
	private String refDate;

	@SerializedName("callback_count")
	private Integer callbackCount;
	@SerializedName("fail_count")
	private Integer failCount;
	@SerializedName("total_time_cost")
	private Integer totalTimeCost;
	@SerializedName("max_time_cost")
	private Integer maxTimeCost;

	/**
	 * @return the refDate
	 */
	public String getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate
	 *            the refDate to set
	 */
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	/**
	 * 回调次数
	 * 
	 * @return the callbackCount
	 */
	public Integer getCallbackCount() {
		return callbackCount;
	}

	/**
	 * 回调次数
	 * 
	 * @param callbackCount
	 *            the callbackCount to set
	 */
	public void setCallbackCount(Integer callbackCount) {
		this.callbackCount = callbackCount;
	}

	/**
	 * 回调失败次数
	 * 
	 * @return the failCount
	 */
	public Integer getFailCount() {
		return failCount;
	}

	/**
	 * 回调失败次数
	 * 
	 * @param failCount
	 *            the failCount to set
	 */
	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	/**
	 * 总耗时
	 * 
	 * @return the totalTimeCost
	 */
	public Integer getTotalTimeCost() {
		return totalTimeCost;
	}

	/**
	 * 总耗时
	 * 
	 * @param totalTimeCost
	 *            the totalTimeCost to set
	 */
	public void setTotalTimeCost(Integer totalTimeCost) {
		this.totalTimeCost = totalTimeCost;
	}

	/**
	 * 最大耗时
	 * 
	 * @return the maxTimeCost
	 */
	public Integer getMaxTimeCost() {
		return maxTimeCost;
	}

	/**
	 * 最大耗时
	 * 
	 * @param maxTimeCost
	 *            the maxTimeCost to set
	 */
	public void setMaxTimeCost(Integer maxTimeCost) {
		this.maxTimeCost = maxTimeCost;
	}

}
