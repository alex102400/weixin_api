package com.shanli.weixin.mp.resp.user;

import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.Tag;
/**
 * 
 * @author alex
 *
 */
public class TagsCreateResp extends BaseResp {
	private Tag tag;

	/**
	 * @return the tag
	 */
	public Tag getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
