package com.shanli.weixin.mp.req.custom;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 客服消息
 * 
 * @author alex
 *
 */
public class CustomMsg {
	private String touser;
	private MediaTypeEnum msgtype;
	private CustomeService customservice;

	public CustomMsg(String touser, MediaTypeEnum msgtype) {
		this.touser = touser;
		this.msgtype = msgtype;
	}

	public static class CustomeService {
		@SerializedName("kf_account")
		private String kfAccount;

		/**
		 * @return the kfAccount
		 */
		public String getKfAccount() {
			return kfAccount;
		}

		/**
		 * @param kfAccount
		 *            the kfAccount to set
		 */
		public void setKfAccount(String kfAccount) {
			this.kfAccount = kfAccount;
		}

	}

	/**
	 * 用户openid
	 * 
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}

	/**
	 * 用户openid
	 * 
	 * @param touser
	 *            the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}

	/**
	 * 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
	 * 
	 * @return the msgtype
	 */
	public MediaTypeEnum getMsgtype() {
		return msgtype;
	}

	/**
	 * 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
	 * 
	 * @param msgtype
	 *            the msgtype to set
	 */
	public void setMsgtype(MediaTypeEnum msgtype) {
		this.msgtype = msgtype;
	}

	/**
	 * @return the customservice
	 */
	public CustomeService getCustomservice() {
		return customservice;
	}

	/**
	 * @param customservice
	 *            the customservice to set
	 */
	public void setCustomservice(CustomeService customservice) {
		this.customservice = customservice;
	}

	/**
	 * 设置客服账号
	 * 
	 * @param kfAccount
	 */
	public void setKfAccount(String kfAccount) {
		if (this.customservice == null) {
			customservice = new CustomeService();
		}
		customservice.kfAccount = kfAccount;
	}
	/*
	 * 转换为JSON字符串
	 * 
	 */
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
