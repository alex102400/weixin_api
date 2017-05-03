package com.shanli.weixin.mp.resp.user;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

public class UserInfoBatchGetResp extends BaseResp {
	@SerializedName("user_info_list")
	private UserInfoResp userInfoList;

	/**
	 * @return the userInfoList
	 */
	public UserInfoResp getUserInfoList() {
		return userInfoList;
	}

	/**
	 * @param userInfoList
	 *            the userInfoList to set
	 */
	public void setUserInfoList(UserInfoResp userInfoList) {
		this.userInfoList = userInfoList;
	}

}
