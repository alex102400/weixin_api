package com.shanli.weixin.mp.resp.user;

import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.Tag;

public class TagsGetResp extends BaseResp {
	private Tag tags;

	/**
	 * @return the tags
	 */
	public Tag getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(Tag tags) {
		this.tags = tags;
	}

}
