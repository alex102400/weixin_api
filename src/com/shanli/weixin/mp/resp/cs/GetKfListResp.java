package com.shanli.weixin.mp.resp.cs;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 公众号中所设置的客服基本信息，包括客服工号、客服昵称、客服登录账号。
 * 
 * @author alex
 *
 */
public class GetKfListResp extends BaseResp {
	@SerializedName("kf_list")
	private KfAccountInfo[] kfList;

	public static class KfAccountInfo extends ServiceAccount{
		
		@SerializedName("kf_nick")
		private String kfNick;
		@SerializedName("kf_headimgurl")
		private String kfHeadImgUrl;
		@SerializedName("kf_wx")
		private String kfWx;
		@SerializedName("invite_wx")
		private String inviteWx;
		@SerializedName("invite_expire_time")
		private String inviteExpireTime;
		@SerializedName("invite_status")
		private String inviteStatus;


		/**
		 * 客服昵称
		 * 
		 * @return the kfNick
		 */
		public String getKfNick() {
			return kfNick;
		}

		/**
		 * 客服昵称
		 * 
		 * @param kfNick
		 *            the kfNick to set
		 */
		public void setKfNick(String kfNick) {
			this.kfNick = kfNick;
		}

		/**
		 * 客服头像
		 * 
		 * @return the kfHeadImgUrl
		 */
		public String getKfHeadImgUrl() {
			return kfHeadImgUrl;
		}

		/**
		 * 客服头像
		 * 
		 * @param kfHeadImgUrl
		 *            the kfHeadImgUrl to set
		 */
		public void setKfHeadImgUrl(String kfHeadImgUrl) {
			this.kfHeadImgUrl = kfHeadImgUrl;
		}

		/**
		 * 如果客服帐号已绑定了客服人员微信号， 则此处显示微信号
		 * 
		 * @return the kfWx
		 */
		public String getKfWx() {
			return kfWx;
		}

		/**
		 * 如果客服帐号已绑定了客服人员微信号， 则此处显示微信号
		 * 
		 * @param kfWx
		 *            the kfWx to set
		 */
		public void setKfWx(String kfWx) {
			this.kfWx = kfWx;
		}

		/**
		 * 如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请， 则此处显示绑定邀请的微信号
		 * 
		 * @return the inviteWx
		 */
		public String getInviteWx() {
			return inviteWx;
		}

		/**
		 * 如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请， 则此处显示绑定邀请的微信号
		 * 
		 * @param inviteWx
		 *            the inviteWx to set
		 */
		public void setInviteWx(String inviteWx) {
			this.inviteWx = inviteWx;
		}

		/**
		 * 如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请， 邀请的过期时间，为unix 时间戳
		 * 
		 * @return the inviteExpireTime
		 */
		public String getInviteExpireTime() {
			return inviteExpireTime;
		}

		/**
		 * 如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请， 邀请的过期时间，为unix 时间戳
		 * 
		 * @param inviteExpireTime
		 *            the inviteExpireTime to set
		 */
		public void setInviteExpireTime(String inviteExpireTime) {
			this.inviteExpireTime = inviteExpireTime;
		}

		/**
		 * 邀请的状态，有等待确认“waiting”，被拒绝“rejected”， 过期“expired”
		 * 
		 * @return the inviteStatus
		 */
		public String getInviteStatus() {
			return inviteStatus;
		}

		/**
		 * 邀请的状态，有等待确认“waiting”，被拒绝“rejected”， 过期“expired”
		 * 
		 * @param inviteStatus
		 *            the inviteStatus to set
		 */
		public void setInviteStatus(String inviteStatus) {
			this.inviteStatus = inviteStatus;
		}

	}

	/**
	 * @return the kfList
	 */
	public KfAccountInfo[] getKfList() {
		return kfList;
	}

	/**
	 * @param kfList
	 *            the kfList to set
	 */
	public void setKfList(KfAccountInfo[] kfList) {
		this.kfList = kfList;
	}

}
