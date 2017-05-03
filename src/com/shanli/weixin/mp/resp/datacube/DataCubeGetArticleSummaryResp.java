package com.shanli.weixin.mp.resp.datacube;

import com.shanli.weixin.bean.BaseResp;

/**
 * 图文群发每日数据
 * 
 * @author alex
 *
 */
public class DataCubeGetArticleSummaryResp extends BaseResp {
	private ArticleSummary[] list;

	public static class ArticleSummary extends NewsSummary {

		private String msgid;
		private String title;

		/**
		 * msgid_index
		 * 
		 * @return the msgid
		 */
		public String getMsgid() {
			return msgid;
		}

		/**
		 * msgid_index
		 * 
		 * @param msgid
		 *            the msgid to set
		 */
		public void setMsgid(String msgid) {
			this.msgid = msgid;
		}

		/**
		 * 图文消息的标题
		 * 
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * 图文消息的标题
		 * 
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

	}

	/**
	 * @return the list
	 */
	public ArticleSummary[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArticleSummary[] list) {
		this.list = list;
	}
}
