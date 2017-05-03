package com.shanli.weixin.mp.resp.datacube;

import com.shanli.weixin.bean.BaseResp;
/**
 * 图文分享转发数据
 * @author alex
 *
 */
public class DataCubeGetUserShareResp extends BaseResp {
	private UserShareCount[] list;
	

	/**
	 * @return the list
	 */
	public UserShareCount[] getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(UserShareCount[] list) {
		this.list = list;
	}
	
}
