package com.shanli.weixin.mp.resp.material;

import com.shanli.weixin.bean.BaseResp;

/**
 * 上传图文消息内的图片获取URL
 * @author alex
 *
 */
public class MediaUploadImgResp extends BaseResp {
	private String url;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
