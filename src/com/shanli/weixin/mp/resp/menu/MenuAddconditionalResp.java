package com.shanli.weixin.mp.resp.menu;

import com.shanli.weixin.bean.BaseResp;

/**
 * 添加个性化菜单后的响应。主要是返回菜单ID。
 * 
 * @author alex
 *
 */
public class MenuAddconditionalResp extends BaseResp {
	private String menuid;

	/**
	 * @return the menuid
	 */
	public String getMenuid() {
		return menuid;
	}

	/**
	 * @param menuid
	 *            the menuid to set
	 */
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
}
