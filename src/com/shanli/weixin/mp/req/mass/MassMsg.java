package com.shanli.weixin.mp.req.mass;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.mp.bean.MediaTypeEnum;

/**
 * 群发消息。 消息类型包括文本text图片image卡券wxcard群发图文mpnews群发视频mpvideo
 * 
 * @author alex
 *
 */
public class MassMsg {
	private Filter filter;// 标签组过滤
	private String[] touser;// 按照openid群发，订阅号不可用，服务号认证后可用

	private MediaTypeEnum msgtype;

	public MassMsg() {
	}

	public static class Filter {
		@SerializedName("is_to_all")
		private boolean isToAll;// 是否进入历史记录

		@SerializedName("tag_id")
		private String tagId;// 标签组ID

		/**
		 * @return the isToAll
		 */
		public boolean isToAll() {
			return isToAll;
		}

		/**
		 * @param isToAll
		 *            the isToAll to set
		 */
		public void setToAll(boolean isToAll) {
			this.isToAll = isToAll;
		}

		/**
		 * @return the tagId
		 */
		public String getTagId() {
			return tagId;
		}

		/**
		 * @param tagId
		 *            the tagId to set
		 */
		public void setTagId(String tagId) {
			this.tagId = tagId;
		}

	}

	/**
	 * @return the filter
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            the filter to set
	 */
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	/**
	 * @return the touser
	 */
	public String[] getTouser() {
		return touser;
	}

	/**
	 * @param touser
	 *            the touser to set
	 */
	public void setTouser(String[] touser) {
		this.touser = touser;
	}

	/**
	 * @return the msgtype
	 */
	public MediaTypeEnum getMsgtype() {
		return msgtype;
	}

	/**
	 * @param msgtype
	 *            the msgtype to set
	 */
	public void setMsgtype(MediaTypeEnum msgtype) {
		this.msgtype = msgtype;
	}
	
	/*
	 * 转换为JSON字符串
	 * 
	 */
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
