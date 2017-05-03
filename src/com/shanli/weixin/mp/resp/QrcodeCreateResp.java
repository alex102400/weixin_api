package com.shanli.weixin.mp.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 二维码
 * 
 * @author alex
 *
 */
public class QrcodeCreateResp extends BaseResp {
	private String ticket;
	@SerializedName("expire_seconds")
	private String expireSeconds;
	private String url;// 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片

	/**
	 * ticket换取二维码
	 * 
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * ticket换取二维码
	 * 
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the expireSeconds
	 */
	public String getExpireSeconds() {
		return expireSeconds;
	}

	/**
	 * @param expireSeconds
	 *            the expireSeconds to set
	 */
	public void setExpireSeconds(String expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图。也可以通过ticket换取二维码
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片。也可以通过ticket换取二维码
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
