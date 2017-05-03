package com.shanli.weixin.mp.resp.user;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

public class TagsGetIdListResp extends BaseResp {
	@SerializedName("tagid_list")
	private int[] tagidList;

	/**
	 * @return the tagidList
	 */
	public int[] getTagidList() {
		return tagidList;
	}

	/**
	 * @param tagidList
	 *            the tagidList to set
	 */
	public void setTagidList(int[] tagidList) {
		this.tagidList = tagidList;
	}

}
