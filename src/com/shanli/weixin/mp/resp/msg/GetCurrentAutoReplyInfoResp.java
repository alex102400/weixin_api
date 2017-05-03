package com.shanli.weixin.mp.resp.msg;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 获取公众号的自动回复规则
 * 
 * @author alex
 *
 */
public class GetCurrentAutoReplyInfoResp extends BaseResp {
	@SerializedName("is_add_friend_reply_open")
	private Integer isAddFriendReplyOpen;// 关注后自动回复是否开启，0代表未开启，1代表开启

	@SerializedName("is_autoreply_open")
	private Integer isAutoReplyOpen;// 消息默认自动回复是否开启，0代表未开启，1代表开启

	@SerializedName("add_friend_autoreply_info")
	private ReplyInfo addFriendAutoReplyInfo;// 关注后自动回复的信息

	@SerializedName("message_default_autoreply_info")
	private ReplyInfo messageDefaultAutoReplyInfo;// 消息默认自动回复的信息

	@SerializedName("keyword_autoreply_info")
	private KeywordReply keywordAutoReplyInfo;// 关键词自动回复的信息

	/**
	 * 自动回复信息
	 * 
	 * @author alex
	 *
	 */
	public static class ReplyInfo {
		/**
		 * 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news）
		 */
		private String type;
		/**
		 * 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
		 */
		private String content;

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}

		/**
		 * @param content
		 *            the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}
	}

	/**
	 * 关键字回复内容
	 * 
	 * @author alex
	 *
	 */
	public static class KeywordReply {
		private KeywordReplyRule[] list;

		/**
		 * @return the list
		 */
		public KeywordReplyRule[] getList() {
			return list;
		}

		/**
		 * @param list
		 *            the list to set
		 */
		public void setList(KeywordReplyRule[] list) {
			this.list = list;
		}

	}

	/**
	 * 关键字回复规则
	 * 
	 * @author alex
	 *
	 */
	public static class KeywordReplyRule {
		@SerializedName("rule_name")
		private String ruleName;

		@SerializedName("create_time")
		private Long createTime;

		/**
		 * 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
		 */
		@SerializedName("reply_mode")
		private String replyMode;

		/**
		 * 关键词设置
		 */
		@SerializedName("keyword_list_info")
		private KeyordInfo[] keywordListInfo;

		/**
		 * 关键词回复内容
		 */
		@SerializedName("reply_list_info")
		private KeywordReplyInfo[] replyListInfo;

		/**
		 * @return the ruleName
		 */
		public String getRuleName() {
			return ruleName;
		}

		/**
		 * @param ruleName
		 *            the ruleName to set
		 */
		public void setRuleName(String ruleName) {
			this.ruleName = ruleName;
		}

		/**
		 * @return the createTime
		 */
		public Long getCreateTime() {
			return createTime;
		}

		/**
		 * @param createTime
		 *            the createTime to set
		 */
		public void setCreateTime(Long createTime) {
			this.createTime = createTime;
		}

		/**
		 * @return the replyMode
		 */
		public String getReplyMode() {
			return replyMode;
		}

		/**
		 * @param replyMode
		 *            the replyMode to set
		 */
		public void setReplyMode(String replyMode) {
			this.replyMode = replyMode;
		}

		/**
		 * @return the keywordListInfo
		 */
		public KeyordInfo[] getKeywordListInfo() {
			return keywordListInfo;
		}

		/**
		 * @param keywordListInfo
		 *            the keywordListInfo to set
		 */
		public void setKeywordListInfo(KeyordInfo[] keywordListInfo) {
			this.keywordListInfo = keywordListInfo;
		}

		/**
		 * @return the replyListInfo
		 */
		public KeywordReplyInfo[] getReplyListInfo() {
			return replyListInfo;
		}

		/**
		 * @param replyListInfo
		 *            the replyListInfo to set
		 */
		public void setReplyListInfo(KeywordReplyInfo[] replyListInfo) {
			this.replyListInfo = replyListInfo;
		}

	}

	/**
	 * 关键词信息
	 * 
	 * @author alex
	 *
	 */
	public static class KeyordInfo {
		/**
		 * 关键词类型
		 */
		private String type;
		/**
		 * 关键词内容
		 */
		private String content;
		/**
		 * 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
		 */
		@SerializedName("match_mode")
		private String match_mode;

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}

		/**
		 * @param content
		 *            the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}

		/**
		 * @return the match_mode
		 */
		public String getMatch_mode() {
			return match_mode;
		}

		/**
		 * @param match_mode
		 *            the match_mode to set
		 */
		public void setMatch_mode(String match_mode) {
			this.match_mode = match_mode;
		}

	}

	/**
	 * 关键词回复信息
	 * 
	 * @author alex
	 *
	 */
	public static class KeywordReplyInfo extends ReplyInfo {
		@SerializedName("news_info")
		private NewsInfo[] newsInfo;

		/**
		 * @return the newsInfo
		 */
		public NewsInfo[] getNewsInfo() {
			return newsInfo;
		}

		/**
		 * @param newsInfo
		 *            the newsInfo to set
		 */
		public void setNewsInfo(NewsInfo[] newsInfo) {
			this.newsInfo = newsInfo;
		}

	}

	/**
	 * 图文回复内容
	 * 
	 * @author alex
	 *
	 */
	public static class NewsInfo {
		/**
		 * 图文列表
		 */
		private NewsArticle[] list;

		/**
		 * @return the list
		 */
		public NewsArticle[] getList() {
			return list;
		}

		/**
		 * @param list
		 *            the list to set
		 */
		public void setList(NewsArticle[] list) {
			this.list = list;
		}

	}

	public static class NewsArticle {

		private String author;// 图文消息的作者
		private String title;// 图文消息的标题

		private String digest;// 图文消息的描述
		@SerializedName("show_cover")
		private Integer showCover;// 是否显示封面，1为显示，0为不显示
		@SerializedName("cover_url")
		private String coverUrl;// 封面图片地址

		@SerializedName("content_url")
		private String contentUrl;// 内容地址
		@SerializedName("source_url")
		private String sourceUrl;// 源地址

		/**
		 * @return the author
		 */
		public String getAuthor() {
			return author;
		}

		/**
		 * @param author
		 *            the author to set
		 */
		public void setAuthor(String author) {
			this.author = author;
		}

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the digest
		 */
		public String getDigest() {
			return digest;
		}

		/**
		 * @param digest
		 *            the digest to set
		 */
		public void setDigest(String digest) {
			this.digest = digest;
		}

		/**
		 * @return the showCover
		 */
		public Integer getShowCover() {
			return showCover;
		}

		/**
		 * @param showCover
		 *            the showCover to set
		 */
		public void setShowCover(Integer showCover) {
			this.showCover = showCover;
		}

		/**
		 * @return the coverUrl
		 */
		public String getCoverUrl() {
			return coverUrl;
		}

		/**
		 * @param coverUrl
		 *            the coverUrl to set
		 */
		public void setCoverUrl(String coverUrl) {
			this.coverUrl = coverUrl;
		}

		/**
		 * @return the contentUrl
		 */
		public String getContentUrl() {
			return contentUrl;
		}

		/**
		 * @param contentUrl
		 *            the contentUrl to set
		 */
		public void setContentUrl(String contentUrl) {
			this.contentUrl = contentUrl;
		}

		/**
		 * @return the sourceUrl
		 */
		public String getSourceUrl() {
			return sourceUrl;
		}

		/**
		 * @param sourceUrl
		 *            the sourceUrl to set
		 */
		public void setSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
		}

	}

	/**
	 * @return the isAddFriendReplyOpen
	 */
	public Integer getIsAddFriendReplyOpen() {
		return isAddFriendReplyOpen;
	}

	/**
	 * @param isAddFriendReplyOpen
	 *            the isAddFriendReplyOpen to set
	 */
	public void setIsAddFriendReplyOpen(Integer isAddFriendReplyOpen) {
		this.isAddFriendReplyOpen = isAddFriendReplyOpen;
	}

	/**
	 * @return the isAutoReplyOpen
	 */
	public Integer getIsAutoReplyOpen() {
		return isAutoReplyOpen;
	}

	/**
	 * @param isAutoReplyOpen
	 *            the isAutoReplyOpen to set
	 */
	public void setIsAutoReplyOpen(Integer isAutoReplyOpen) {
		this.isAutoReplyOpen = isAutoReplyOpen;
	}

	/**
	 * @return the addFriendAutoReplyInfo
	 */
	public ReplyInfo getAddFriendAutoReplyInfo() {
		return addFriendAutoReplyInfo;
	}

	/**
	 * @param addFriendAutoReplyInfo
	 *            the addFriendAutoReplyInfo to set
	 */
	public void setAddFriendAutoReplyInfo(ReplyInfo addFriendAutoReplyInfo) {
		this.addFriendAutoReplyInfo = addFriendAutoReplyInfo;
	}

	/**
	 * @return the messageDefaultAutoReplyInfo
	 */
	public ReplyInfo getMessageDefaultAutoReplyInfo() {
		return messageDefaultAutoReplyInfo;
	}

	/**
	 * @param messageDefaultAutoReplyInfo
	 *            the messageDefaultAutoReplyInfo to set
	 */
	public void setMessageDefaultAutoReplyInfo(ReplyInfo messageDefaultAutoReplyInfo) {
		this.messageDefaultAutoReplyInfo = messageDefaultAutoReplyInfo;
	}

	/**
	 * @return the keywordAutoReplyInfo
	 */
	public KeywordReply getKeywordAutoReplyInfo() {
		return keywordAutoReplyInfo;
	}

	/**
	 * @param keywordAutoReplyInfo
	 *            the keywordAutoReplyInfo to set
	 */
	public void setKeywordAutoReplyInfo(KeywordReply keywordAutoReplyInfo) {
		this.keywordAutoReplyInfo = keywordAutoReplyInfo;
	}
}
