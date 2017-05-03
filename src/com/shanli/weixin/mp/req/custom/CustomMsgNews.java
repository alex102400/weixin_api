package com.shanli.weixin.mp.req.custom;

import java.util.ArrayList;

import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 图文消息（点击跳转到外链） 图文消息条数限制在8条以内，注意，如果图文数超过8，则将会无响应
 * 
 * @author alex
 *
 */
public class CustomMsgNews extends CustomMsg {
	/**
	 * 最大新闻条数
	 */
	public static int MAX_SIZE = 8;
	private News news = new News();

	public CustomMsgNews(String touser) {
		super(touser,MediaTypeEnum.news);
	}

	/**
	 * 添加新闻，超过8条直接忽略
	 * 
	 * @param title
	 * @param description
	 * @param url
	 * @param picurl
	 * @return
	 */
	public CustomMsgNews addArticle(String title, String description, String url, String picurl) {
		if (news.articles.size() > MAX_SIZE) {
			return this;
		}
		Article article = new Article(title, description, url, picurl);
		news.articles.add(article);
		return this;
	}

	public static class News {
		private ArrayList<Article> articles = new ArrayList<Article>(MAX_SIZE);

		/**
		 * @return the articles
		 */
		public ArrayList<Article> getArticles() {
			return articles;
		}

		/**
		 * @param articles
		 *            the articles to set
		 */
		public void setArticles(ArrayList<Article> articles) {
			this.articles = articles;
		}

	}

	public static class Article {
		private String title;
		private String description;
		private String url;
		private String picurl;

		public Article() {
			super();
		}

		public Article(String title, String description, String url, String picurl) {
			super();
			this.title = title;
			this.description = description;
			this.url = url;
			this.picurl = picurl;
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

		/**
		 * @return the picurl
		 */
		public String getPicurl() {
			return picurl;
		}

		/**
		 * @param picurl
		 *            the picurl to set
		 */
		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}

	}

	/**
	 * @return the news
	 */
	public News getNews() {
		return news;
	}

	/**
	 * @param news
	 *            the news to set
	 */
	public void setNews(News news) {
		this.news = news;
	}
}
