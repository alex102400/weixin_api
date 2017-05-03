package com.shanli.weixin.mp.resp.material;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.req.Article;

/**
 * 获取永久素材
 * 
 * @author alex
 *
 */
public class MaterialGetResp extends BaseResp {
	private String filename;// 原始文件名

	/**
	 * 图文消息列表
	 */
	@SerializedName("news_item")
	private Article[] newsItem;
	/**
	 * 视频标题
	 */
	private String title;
	/**
	 * 视频描述
	 */
	private String description;
	/**
	 * 视频URL
	 */
	@SerializedName("down_url")
	private String downUrl;

	/**
	 * 原始文件名
	 * 
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * 原始文件名
	 * 
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * 图文消息列表
	 * 
	 * @return the newsItem
	 */
	public Article[] getNewsItem() {
		return newsItem;
	}

	/**
	 * 图文消息列表
	 * 
	 * @param newsItem
	 *            the newsItem to set
	 */
	public void setNewsItem(Article[] newsItem) {
		this.newsItem = newsItem;
	}

	/**
	 * 视频标题
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 视频标题
	 * 
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 视频描述
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 视频描述
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 视频URL
	 * 
	 * @return the downUrl
	 */
	public String getDownUrl() {
		return downUrl;
	}

	/**
	 * 视频URL
	 * 
	 * @param downUrl
	 *            the downUrl to set
	 */
	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}

}
