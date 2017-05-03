package com.shanli.weixin.mp.req.reply;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 回复图文
 * 
 * @author alex
 *
 */
public class ReplyNews extends BaseReply {
	private int articleCount;
	private ArticleItem articles=new ArticleItem();
	private int index;

	public ReplyNews(UserMsg userMsg, int articleCount) {
		super(userMsg, MediaTypeEnum.news);
		this.articleCount = articleCount;
		this.articles.item = new Article[articleCount];
	}

	/**
	 * 添加条目
	 * 
	 * @param title
	 * @param description
	 * @param picUrl
	 * @param url
	 * @return
	 */
	public ReplyNews addItem(String title, String description, String picUrl, String url) {
		this.articles.item[index++] = new Article(title, description, picUrl, url);
		return this;
	}

	public static class ArticleItem {
		@SerializedName("item")
		private Article[] item;

		/**
		 * @return the item
		 */
		public Article[] getItem() {
			return item;
		}

		/**
		 * @param item
		 *            the item to set
		 */
		public void setItem(Article[] item) {
			this.item = item;
		}

	}

	public static class Article {
		private String title;
		private String description;
		private String picUrl;
		private String url;

		public Article(String title, String description, String picUrl, String url) {
			super();
			this.title = title;
			this.description = description;
			this.picUrl = picUrl;
			this.url = url;
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
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the picUrl
		 */
		public String getPicUrl() {
			return picUrl;
		}

		/**
		 * @param picUrl
		 *            the picUrl to set
		 */
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		/**
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * @param url
		 *            the url to set
		 */
		public void setUrl(String url) {
			this.url = url;
		}

	}

	/**
	 * @return the articleCount
	 */
	public int getArticleCount() {
		return articleCount;
	}

	/**
	 * @param articleCount
	 *            the articleCount to set
	 */
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	/**
	 * @return the articles
	 */
	public ArticleItem getArticles() {
		return articles;
	}

	/**
	 * @param articles
	 *            the articles to set
	 */
	public void setArticles(ArticleItem articles) {
		this.articles = articles;
	}
}
