package com.shanli.weixin.mp.recv.event;

/**
 * 点击菜单跳转链接时的事件推送
 * 
 * @author alex
 *
 */
public class MsgEventMenuView extends MsgEventMenuClick {
	private String menuId;// 菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。

	/**
	 * 菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
	 * 
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * 菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
	 * 
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

}
