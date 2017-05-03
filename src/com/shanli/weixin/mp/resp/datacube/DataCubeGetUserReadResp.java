package com.shanli.weixin.mp.resp.datacube;

import com.shanli.weixin.bean.BaseResp;

/**
 * 图文统计数据
 * 
 * @author alex
 *
 */
public class DataCubeGetUserReadResp extends BaseResp {
	private NewsSummary[] list;

	/**
	 * @return the list
	 */
	public NewsSummary[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(NewsSummary[] list) {
		this.list = list;
	}
}
