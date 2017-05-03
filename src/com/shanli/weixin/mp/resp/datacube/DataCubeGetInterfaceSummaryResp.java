package com.shanli.weixin.mp.resp.datacube;

import com.shanli.weixin.bean.BaseResp;
/**
 * 接口分析数据
 * @author alex
 *
 */
public class DataCubeGetInterfaceSummaryResp extends BaseResp {
	private InterfaceSummary[] list;

	/**
	 * @return the list
	 */
	public InterfaceSummary[] getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(InterfaceSummary[] list) {
		this.list = list;
	}
	
}
