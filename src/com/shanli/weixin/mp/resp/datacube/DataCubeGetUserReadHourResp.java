package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 图文统计分时数据
 * 
 * @author alex
 *
 */
public class DataCubeGetUserReadHourResp extends BaseResp {
	private UserReadHour[] list;

	public static class UserReadHour extends NewsSummary {
		@SerializedName("ref_hour")
		private Integer refHour;

		@SerializedName("user_source")
		private String userSource;

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

		/**
		 * 在获取图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。0:会话;1.好友;2.朋友圈;3.腾讯微博;4.历史消息页;5.其他
		 * 
		 * @return the userSource
		 */
		public String getUserSource() {
			return userSource;
		}

		/**
		 * 在获取图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。0:会话;1.好友;2.朋友圈;3.腾讯微博;4.历史消息页;5.其他
		 * 
		 * @param userSource
		 *            the userSource to set
		 */
		public void setUserSource(String userSource) {
			this.userSource = userSource;
		}

	}

	/**
	 * @return the list
	 */
	public UserReadHour[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(UserReadHour[] list) {
		this.list = list;
	}
}
