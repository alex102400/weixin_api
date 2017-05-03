package com.shanli.weixin.mp.resp.menu;

import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.Button;

/**
 * 测试个性化菜单匹配结果
 * 
 * @author alex
 *
 */
public class MenuTrymatchResp extends BaseResp{
	private Button[] button;

	/**
	 * @return the button
	 */
	public Button[] getButton() {
		return button;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(Button[] button) {
		this.button = button;
	}
	
}
