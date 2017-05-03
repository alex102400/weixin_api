package com.shanli.weixin.mp.resp.cs;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 客户会话状态
 * 
 * @author alex
 *
 */
public class GetWaitCaseResp extends BaseResp {
	private Integer count;
	private WaitCase[] waitcaselist;

	public static class WaitCase {
		@SerializedName("latest_time")
		private Long latestTime;
		private String openid;

		/**
		 * 粉丝的最后一条消息的时间
		 * 
		 * @return the latestTime
		 */
		public Long getLatestTime() {
			return latestTime;
		}

		/**
		 * 粉丝的最后一条消息的时间
		 * 
		 * @param latestTime
		 *            the latestTime to set
		 */
		public void setLatestTime(Long latestTime) {
			this.latestTime = latestTime;
		}

		/**
		 * @return the openid
		 */
		public String getOpenid() {
			return openid;
		}

		/**
		 * @param openid
		 *            the openid to set
		 */
		public void setOpenid(String openid) {
			this.openid = openid;
		}

	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the waitcaselist
	 */
	public WaitCase[] getWaitcaselist() {
		return waitcaselist;
	}

	/**
	 * @param waitcaselist
	 *            the waitcaselist to set
	 */
	public void setWaitcaselist(WaitCase[] waitcaselist) {
		this.waitcaselist = waitcaselist;
	}
}
