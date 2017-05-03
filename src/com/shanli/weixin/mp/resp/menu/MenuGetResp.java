package com.shanli.weixin.mp.resp.menu;

import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.Button;
import com.shanli.weixin.mp.bean.Matchrule;

/**
 * 菜单查询结果
 * 
 * @author alex
 *
 */
public class MenuGetResp extends BaseResp{
	private Menu menu;// 默认菜单
	private ConditionalMenu conditionalmenu;// 个性化菜单

	public class Menu {
		private Button[] button;

		private String menuid;

		/**
		 * @return the button
		 */
		public Button[] getButton() {
			return button;
		}

		/**
		 * @param button
		 *            the button to set
		 */
		public void setButton(Button[] button) {
			this.button = button;
		}

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
	
	public class ConditionalMenu extends Menu {
		/**
		 * 个性化菜单匹配规则
		 */
		private Matchrule matchrule;

		/**
		 * 个性化菜单匹配规则
		 * 
		 * @return the matchrule
		 */
		public Matchrule getMatchrule() {
			return matchrule;
		}

		/**
		 * 个性化菜单匹配规则
		 * 
		 * @param matchrule
		 *            the matchrule to set
		 */
		public void setMatchrule(Matchrule matchrule) {
			this.matchrule = matchrule;
		}

	}

	/**
	 * 默认菜单
	 * 
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * 默认菜单
	 * 
	 * @param menu
	 *            the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * 个性化菜单
	 * 
	 * @return the conditionalmenu
	 */
	public ConditionalMenu getConditionalmenu() {
		return conditionalmenu;
	}

	/**
	 * 个性化菜单
	 * 
	 * @param conditionalmenu
	 *            the conditionalmenu to set
	 */
	public void setConditionalmenu(ConditionalMenu conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}
}
