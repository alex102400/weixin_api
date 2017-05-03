package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;

/**
 * 图文数据统计
 * 
 * @author alex
 *
 */
public class NewsSummary {
	@SerializedName("ref_date")
	private String refDate;

	@SerializedName("int_page_read_user")
	private Integer intPageReadUser;
	@SerializedName("int_page_read_count")
	private Integer intPageReadCount;
	@SerializedName("ori_page_read_user")
	private Integer oriPageReadUser;
	@SerializedName("ori_page_read_count")
	private Integer oriPageReadCount;
	@SerializedName("share_user")
	private Integer shareUser;
	@SerializedName("share_count")
	private Integer shareCount;
	@SerializedName("add_to_fav_user")
	private Integer addToFavUser;
	@SerializedName("add_to_fav_count")
	private Integer addToFavCount;

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
	 * 阅读人数
	 * 
	 * @return the intPageReadUser
	 */
	public Integer getIntPageReadUser() {
		return intPageReadUser;
	}

	/**
	 * 阅读人数
	 * 
	 * @param intPageReadUser
	 *            the intPageReadUser to set
	 */
	public void setIntPageReadUser(Integer intPageReadUser) {
		this.intPageReadUser = intPageReadUser;
	}

	/**
	 * 阅读次数
	 * 
	 * @return the intPageReadCount
	 */
	public Integer getIntPageReadCount() {
		return intPageReadCount;
	}

	/**
	 * 阅读次数
	 * 
	 * @param intPageReadCount
	 *            the intPageReadCount to set
	 */
	public void setIntPageReadCount(Integer intPageReadCount) {
		this.intPageReadCount = intPageReadCount;
	}

	/**
	 * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数
	 * 
	 * @return the oriPageReadUser
	 */
	public Integer getOriPageReadUser() {
		return oriPageReadUser;
	}

	/**
	 * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数
	 * 
	 * @param oriPageReadUser
	 *            the oriPageReadUser to set
	 */
	public void setOriPageReadUser(Integer oriPageReadUser) {
		this.oriPageReadUser = oriPageReadUser;
	}

	/**
	 * 原文页（点击图文页“阅读原文”进入的页面）的阅读次数
	 * 
	 * @return the oriPageReadCount
	 */
	public Integer getOriPageReadCount() {
		return oriPageReadCount;
	}

	/**
	 * 原文页（点击图文页“阅读原文”进入的页面）的阅读次数
	 * 
	 * @param oriPageReadCount
	 *            the oriPageReadCount to set
	 */
	public void setOriPageReadCount(Integer oriPageReadCount) {
		this.oriPageReadCount = oriPageReadCount;
	}

	/**
	 * 分享的人数
	 * 
	 * @return the shareUser
	 */
	public Integer getShareUser() {
		return shareUser;
	}

	/**
	 * 分享的人数
	 * 
	 * @param shareUser
	 *            the shareUser to set
	 */
	public void setShareUser(Integer shareUser) {
		this.shareUser = shareUser;
	}

	/**
	 * 分享的次数
	 * 
	 * @return the shareCount
	 */
	public Integer getShareCount() {
		return shareCount;
	}

	/**
	 * 分享的次数
	 * 
	 * @param shareCount
	 *            the shareCount to set
	 */
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	/**
	 * 收藏的人数
	 * 
	 * @return the addToFavUser
	 */
	public Integer getAddToFavUser() {
		return addToFavUser;
	}

	/**
	 * 收藏的人数
	 * 
	 * @param addToFavUser
	 *            the addToFavUser to set
	 */
	public void setAddToFavUser(Integer addToFavUser) {
		this.addToFavUser = addToFavUser;
	}

	/**
	 * 收藏的次数
	 * 
	 * @return the addToFavCount
	 */
	public Integer getAddToFavCount() {
		return addToFavCount;
	}

	/**
	 * 收藏的次数
	 * 
	 * @param addToFavCount
	 *            the addToFavCount to set
	 */
	public void setAddToFavCount(Integer addToFavCount) {
		this.addToFavCount = addToFavCount;
	}
}
