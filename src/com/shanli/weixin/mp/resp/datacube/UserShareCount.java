package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;

/**
 * 分享转发数据
 * 
 * @author alex
 *
 */
public class UserShareCount {
	@SerializedName("ref_date")
	private String refDate;
	@SerializedName("share_user")
	private Integer shareUser;
	@SerializedName("share_count")
	private Integer shareCount;
	@SerializedName("share_scene")
	private Integer shareScene;
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
	 * 分享人数
	 * 
	 * @return the shareUser
	 */
	public Integer getShareUser() {
		return shareUser;
	}

	/**
	 * 分享人数
	 * 
	 * @param shareUser
	 *            the shareUser to set
	 */
	public void setShareUser(Integer shareUser) {
		this.shareUser = shareUser;
	}

	/**
	 * 分享次数
	 * 
	 * @return the shareCount
	 */
	public Integer getShareCount() {
		return shareCount;
	}

	/**
	 * 分享次数
	 * 
	 * @param shareCount
	 *            the shareCount to set
	 */
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	/**
	 * 分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 * 
	 * @return the shareScene
	 */
	public Integer getShareScene() {
		return shareScene;
	}

	/**
	 * 分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 * 
	 * @param shareScene
	 *            the shareScene to set
	 */
	public void setShareScene(Integer shareScene) {
		this.shareScene = shareScene;
	}

}
