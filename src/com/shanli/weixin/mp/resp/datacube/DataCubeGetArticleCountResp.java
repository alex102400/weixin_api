package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 图文群发总数据。需要注意结果中所有的次数人数都是从群发日起到指定统计日的总量数据。
 * 
 * @author alex
 *
 */
public class DataCubeGetArticleCountResp extends BaseResp {
	private ArticleCount[] list;

	public static class ArticleCount {

		@SerializedName("ref_date")
		private String refDate;
		private String msgid;
		private String title;

		private CountDetail[] details;

		/**
		 * 数据的日期
		 * 
		 * @return the refDate
		 */
		public String getRefDate() {
			return refDate;
		}

		/**
		 * 数据的日期
		 * 
		 * @param refDate
		 *            the refDate to set
		 */
		public void setRefDate(String refDate) {
			this.refDate = refDate;
		}

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

		/**
		 * @return the details
		 */
		public CountDetail[] getDetails() {
			return details;
		}

		/**
		 * @param details
		 *            the details to set
		 */
		public void setDetails(CountDetail[] details) {
			this.details = details;
		}

	}

	public static class CountDetail extends ArticleCount {
		@SerializedName("stat_date")
		private String statDate;

		@SerializedName("target_user")
		private String targetUser;

		@SerializedName("int_page_from_session_read_user")
		private Integer intPageFromSessionReadUser;
		@SerializedName("int_page_from_session_read_count")
		private Integer intPageFromSessionReadCount;
		@SerializedName("int_page_from_hist_msg_read_user")
		private Integer intPageFromHistReadUser;
		@SerializedName("int_page_from_hist_msg_read_count")
		private Integer intPageFromHistReadCount;
		@SerializedName("int_page_from_feed_read_user")
		private Integer intPageFromFeedReadUser;
		@SerializedName("int_page_from_feed_read_count")
		private Integer intPageFromFeedReadCount;
		@SerializedName("int_page_from_friends_read_user")
		private Integer intPageFromFriendsReadUser;
		@SerializedName("int_page_from_friends_read_count")
		private Integer intPageFromFriendsReadCount;
		@SerializedName("int_page_from_other_read_user")
		private Integer intPageFromOtherReadUser;
		@SerializedName("int_page_from_other_read_count")
		private Integer intPageFromOtherReadCount;
		@SerializedName("feed_share_from_session_user")
		private Integer feedShareFromSessionUser;
		@SerializedName("feed_share_from_session_cnt")
		private Integer feedShareFromSessionCount;
		@SerializedName("feed_share_from_feed_user")
		private Integer feedShareFromFeedUser;
		@SerializedName("feed_share_from_feed_cnt")
		private Integer feedShareFromFeedCount;
		@SerializedName("feed_share_from_other_user")
		private Integer feedShareFromOtherUser;
		@SerializedName("feed_share_from_other_cnt")
		private Integer feedShareFromOtherCount;

		/**
		 * 送达总人数
		 * 
		 * @return the targetUser
		 */
		public String getTargetUser() {
			return targetUser;
		}

		/**
		 * 送达总人数
		 * 
		 * @param targetUser
		 *            the targetUser to set
		 */
		public void setTargetUser(String targetUser) {
			this.targetUser = targetUser;
		}

		/**
		 * 统计日期
		 * 
		 * @return the refDate
		 */
		public String getStatDate() {
			return statDate;
		}

		/**
		 * 统计日期
		 * 
		 * @param statDate
		 *            the statDate to set
		 */
		public void setStatDate(String statDate) {
			this.statDate = statDate;
		}

		/**
		 * 公众号会话阅读人数
		 * 
		 * @return the intPageFromSessionReadUser
		 */
		public Integer getIntPageFromSessionReadUser() {
			return intPageFromSessionReadUser;
		}

		/**
		 * 公众号会话阅读人数
		 * 
		 * @param intPageFromSessionReadUser
		 *            the intPageFromSessionReadUser to set
		 */
		public void setIntPageFromSessionReadUser(Integer intPageFromSessionReadUser) {
			this.intPageFromSessionReadUser = intPageFromSessionReadUser;
		}

		/**
		 * 公众号会话阅读次数
		 * 
		 * @return the intPageFromSessionReadCount
		 */
		public Integer getIntPageFromSessionReadCount() {
			return intPageFromSessionReadCount;
		}

		/**
		 * 公众号会话阅读次数
		 * 
		 * @param intPageFromSessionReadCount
		 *            the intPageFromSessionReadCount to set
		 */
		public void setIntPageFromSessionReadCount(Integer intPageFromSessionReadCount) {
			this.intPageFromSessionReadCount = intPageFromSessionReadCount;
		}

		/**
		 * 历史消息页阅读人数
		 * 
		 * @return the intPageFromHistReadUser
		 */
		public Integer getIntPageFromHistReadUser() {
			return intPageFromHistReadUser;
		}

		/**
		 * 历史消息页阅读人数
		 * 
		 * @param intPageFromHistReadUser
		 *            the intPageFromHistReadUser to set
		 */
		public void setIntPageFromHistReadUser(Integer intPageFromHistReadUser) {
			this.intPageFromHistReadUser = intPageFromHistReadUser;
		}

		/**
		 * 历史消息页阅读次数
		 * 
		 * @return the intPageFromHistReadCount
		 */
		public Integer getIntPageFromHistReadCount() {
			return intPageFromHistReadCount;
		}

		/**
		 * 历史消息页阅读次数
		 * 
		 * @param intPageFromHistReadCount
		 *            the intPageFromHistReadCount to set
		 */
		public void setIntPageFromHistReadCount(Integer intPageFromHistReadCount) {
			this.intPageFromHistReadCount = intPageFromHistReadCount;
		}

		/**
		 * 朋友圈阅读人数
		 * 
		 * @return the intPageFromFeedReadUser
		 */
		public Integer getIntPageFromFeedReadUser() {
			return intPageFromFeedReadUser;
		}

		/**
		 * 朋友圈阅读人数
		 * 
		 * @param intPageFromFeedReadUser
		 *            the intPageFromFeedReadUser to set
		 */
		public void setIntPageFromFeedReadUser(Integer intPageFromFeedReadUser) {
			this.intPageFromFeedReadUser = intPageFromFeedReadUser;
		}

		/**
		 * 朋友圈阅读次数
		 * 
		 * @return the intPageFromFeedReadCount
		 */
		public Integer getIntPageFromFeedReadCount() {
			return intPageFromFeedReadCount;
		}

		/**
		 * 朋友圈阅读次数
		 * 
		 * @param intPageFromFeedReadCount
		 *            the intPageFromFeedReadCount to set
		 */
		public void setIntPageFromFeedReadCount(Integer intPageFromFeedReadCount) {
			this.intPageFromFeedReadCount = intPageFromFeedReadCount;
		}

		/**
		 * 好友转发阅读人数
		 * 
		 * @return the intPageFromFriendsReadUser
		 */
		public Integer getIntPageFromFriendsReadUser() {
			return intPageFromFriendsReadUser;
		}

		/**
		 * 好友转发阅读人数
		 * 
		 * @param intPageFromFriendsReadUser
		 *            the intPageFromFriendsReadUser to set
		 */
		public void setIntPageFromFriendsReadUser(Integer intPageFromFriendsReadUser) {
			this.intPageFromFriendsReadUser = intPageFromFriendsReadUser;
		}

		/**
		 * 好友转发阅读次数
		 * 
		 * @return the intPageFromFriendsReadCount
		 */
		public Integer getIntPageFromFriendsReadCount() {
			return intPageFromFriendsReadCount;
		}

		/**
		 * 好友转发阅读次数
		 * 
		 * @param intPageFromFriendsReadCount
		 *            the intPageFromFriendsReadCount to set
		 */
		public void setIntPageFromFriendsReadCount(Integer intPageFromFriendsReadCount) {
			this.intPageFromFriendsReadCount = intPageFromFriendsReadCount;
		}

		/**
		 * 其他场景阅读人数
		 * 
		 * @return the intPageFromOtherReadUser
		 */
		public Integer getIntPageFromOtherReadUser() {
			return intPageFromOtherReadUser;
		}

		/**
		 * 其他场景阅读人数
		 * 
		 * @param intPageFromOtherReadUser
		 *            the intPageFromOtherReadUser to set
		 */
		public void setIntPageFromOtherReadUser(Integer intPageFromOtherReadUser) {
			this.intPageFromOtherReadUser = intPageFromOtherReadUser;
		}

		/**
		 * 其他场景阅读次数
		 * 
		 * @return the intPageFromOtherReadCount
		 */
		public Integer getIntPageFromOtherReadCount() {
			return intPageFromOtherReadCount;
		}

		/**
		 * 其他场景阅读次数
		 * 
		 * @param intPageFromOtherReadCount
		 *            the intPageFromOtherReadCount to set
		 */
		public void setIntPageFromOtherReadCount(Integer intPageFromOtherReadCount) {
			this.intPageFromOtherReadCount = intPageFromOtherReadCount;
		}

		/**
		 * 公众号会话转发朋友圈人数
		 * 
		 * @return the feedShareFromSessionUser
		 */
		public Integer getFeedShareFromSessionUser() {
			return feedShareFromSessionUser;
		}

		/**
		 * 公众号会话转发朋友圈人数
		 * 
		 * @param feedShareFromSessionUser
		 *            the feedShareFromSessionUser to set
		 */
		public void setFeedShareFromSessionUser(Integer feedShareFromSessionUser) {
			this.feedShareFromSessionUser = feedShareFromSessionUser;
		}

		/**
		 * 公众号会话转发朋友圈次数
		 * 
		 * @return the feedShareFromSessionCount
		 */
		public Integer getFeedShareFromSessionCount() {
			return feedShareFromSessionCount;
		}

		/**
		 * 公众号会话转发朋友圈次数
		 * 
		 * @param feedShareFromSessionCount
		 *            the feedShareFromSessionCount to set
		 */
		public void setFeedShareFromSessionCount(Integer feedShareFromSessionCount) {
			this.feedShareFromSessionCount = feedShareFromSessionCount;
		}

		/**
		 * 朋友圈转发朋友圈人数
		 * 
		 * @return the feedShareFromFeedUser
		 */
		public Integer getFeedShareFromFeedUser() {
			return feedShareFromFeedUser;
		}

		/**
		 * 朋友圈转发朋友圈人数
		 * 
		 * @param feedShareFromFeedUser
		 *            the feedShareFromFeedUser to set
		 */
		public void setFeedShareFromFeedUser(Integer feedShareFromFeedUser) {
			this.feedShareFromFeedUser = feedShareFromFeedUser;
		}

		/**
		 * 朋友圈转发朋友圈次数
		 * 
		 * @return the feedShareFromFeedCount
		 */
		public Integer getFeedShareFromFeedCount() {
			return feedShareFromFeedCount;
		}

		/**
		 * 朋友圈转发朋友圈次数
		 * 
		 * @param feedShareFromFeedCount
		 *            the feedShareFromFeedCount to set
		 */
		public void setFeedShareFromFeedCount(Integer feedShareFromFeedCount) {
			this.feedShareFromFeedCount = feedShareFromFeedCount;
		}

		/**
		 * 其他场景转发朋友圈人数
		 * 
		 * @return the feedShareFromOtherUser
		 */
		public Integer getFeedShareFromOtherUser() {
			return feedShareFromOtherUser;
		}

		/**
		 * 其他场景转发朋友圈人数
		 * 
		 * @param feedShareFromOtherUser
		 *            the feedShareFromOtherUser to set
		 */
		public void setFeedShareFromOtherUser(Integer feedShareFromOtherUser) {
			this.feedShareFromOtherUser = feedShareFromOtherUser;
		}

		/**
		 * 其他场景转发朋友圈次数
		 * 
		 * @return the feedShareFromOtherCount
		 */
		public Integer getFeedShareFromOtherCount() {
			return feedShareFromOtherCount;
		}

		/**
		 * 其他场景转发朋友圈次数
		 * 
		 * @param feedShareFromOtherCount
		 *            the feedShareFromOtherCount to set
		 */
		public void setFeedShareFromOtherCount(Integer feedShareFromOtherCount) {
			this.feedShareFromOtherCount = feedShareFromOtherCount;
		}

	}

	/**
	 * @return the list
	 */
	public ArticleCount[] getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArticleCount[] list) {
		this.list = list;
	}
}
