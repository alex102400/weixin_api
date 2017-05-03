package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 用户增减数据
 * 
 * @author alex
 *
 */
public class DataCubeGetUserSummaryResp extends BaseResp {
	private UserSummary[] list;

	public static class UserSummary {
		@SerializedName("ref_date")
		private String refDate;
		@SerializedName("user_source")
		private Integer userSource;
		@SerializedName("new_user")
		private Integer newUser;
		@SerializedName("cancel_user")
		private Integer cancelUser;

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
		 * 用户的渠道，数值代表的含义如下： 0代表其他合计 1代表公众号搜索 17代表名片分享 30代表扫描二维码 43代表图文页右上角菜单
		 * 51代表支付后关注（在支付完成页） 57代表图文页内公众号名称 75代表公众号文章广告 78代表朋友圈广告
		 * 
		 * @return the userSource
		 */
		public Integer getUserSource() {
			return userSource;
		}

		/**
		 * 用户的渠道，数值代表的含义如下： 0代表其他合计 1代表公众号搜索 17代表名片分享 30代表扫描二维码 43代表图文页右上角菜单
		 * 51代表支付后关注（在支付完成页） 57代表图文页内公众号名称 75代表公众号文章广告 78代表朋友圈广告
		 * 
		 * @param userSource
		 *            the userSource to set
		 */
		public void setUserSource(Integer userSource) {
			this.userSource = userSource;
		}

		/**
		 * 新增的用户数量
		 * 
		 * @return the newUser
		 */
		public Integer getNewUser() {
			return newUser;
		}

		/**
		 * 
		 * 新增的用户数量
		 * 
		 * @param newUser
		 *            the newUser to set
		 */
		public void setNewUser(Integer newUser) {
			this.newUser = newUser;
		}

		/**
		 * 取消关注的用户数量
		 * 
		 * @return the cancelUser
		 */
		public Integer getCancelUser() {
			return cancelUser;
		}

		/**
		 * 取消关注的用户数量
		 * 
		 * @param cancelUser
		 *            the cancelUser to set
		 */
		public void setCancelUser(Integer cancelUser) {
			this.cancelUser = cancelUser;
		}

	}

	/**
	 * @return the list
	 */
	public UserSummary[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(UserSummary[] list) {
		this.list = list;
	}
}
