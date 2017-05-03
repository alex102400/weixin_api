package com.shanli.weixin.mp.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 短链接
 * @author alex
 *
 */
public class ShortUrlResp extends BaseResp {
	@SerializedName("short_url")
	private String shortUrl;

	/**
	 * @return the shortUrl
	 */
	public String getShortUrl() {
		return shortUrl;
	}

	/**
	 * @param shortUrl the shortUrl to set
	 */
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	
}
