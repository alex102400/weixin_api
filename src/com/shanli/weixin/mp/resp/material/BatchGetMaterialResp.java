package com.shanli.weixin.mp.resp.material;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.req.Article;

/**
 * 获取素材列表
 * 
 * @author alex
 *
 */
public class BatchGetMaterialResp extends BaseResp {
	@SerializedName("total_count")
	private Long totalCount;// 该类型的素材的总数
	@SerializedName("item_count")
	private Long itemCount;// 本次调用获取的素材的数量
	private Item[] item;

	public static class Item {
		@SerializedName("media_id")
		private String mediaId;
		/**
		 * 素材名称
		 */
		private String name;

		@SerializedName("update_time")
		private Long updateTime;

		private String url;
		/**
		 * 图文素材。
		 */
		private NewsContent content;

		/**
		 * @return the mediaId
		 */
		public String getMediaId() {
			return mediaId;
		}

		/**
		 * @param mediaId
		 *            the mediaId to set
		 */
		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		/**
		 * 文件名
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * 文件名
		 * 
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the updateTime
		 */
		public Long getUpdateTime() {
			return updateTime;
		}

		/**
		 * @param updateTime
		 *            the updateTime to set
		 */
		public void setUpdateTime(Long updateTime) {
			this.updateTime = updateTime;
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
		 * @return the content
		 */
		public NewsContent getContent() {
			return content;
		}

		/**
		 * @param content
		 *            the content to set
		 */
		public void setContent(NewsContent content) {
			this.content = content;
		}

	}

	public static class NewsContent {

		@SerializedName("news_item")
		private Article[] newsItem;

		/**
		 * @return the newsItem
		 */
		public Article[] getNewsItem() {
			return newsItem;
		}

		/**
		 * @param newsItem
		 *            the newsItem to set
		 */
		public void setNewsItem(Article[] newsItem) {
			this.newsItem = newsItem;
		}

	}

	/**
	 * 该类型的素材的总数
	 * 
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/**
	 * 该类型的素材的总数
	 * 
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 本次调用获取的素材的数量
	 * 
	 * @return the itemCount
	 */
	public Long getItemCount() {
		return itemCount;
	}

	/**
	 * 本次调用获取的素材的数量
	 * 
	 * @param itemCount
	 *            the itemCount to set
	 */
	public void setItemCount(Long itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * @return the item
	 */
	public Item[] getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(Item[] item) {
		this.item = item;
	}
}
