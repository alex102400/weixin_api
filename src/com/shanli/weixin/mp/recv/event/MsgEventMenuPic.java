package com.shanli.weixin.mp.recv.event;

import com.google.gson.Gson;

/**
 * 弹出系统拍照发图的事件推送
 * 
 * @author alex
 *
 */
public class MsgEventMenuPic extends MsgEventMenuClick {
	private SendPicsInfo sendPicsInfo;// 发送的图片信息

	/**
	 * 发送的图片信息
	 * 
	 * @author alex
	 *
	 */
	public static class SendPicsInfo {
		private Integer count;// 图片数量
		private PicList picList;// 图片列表

		/**
		 * 图片数量
		 * 
		 * @return the count
		 */
		public Integer getCount() {
			return count;
		}

		/**
		 * 图片数量
		 * 
		 * @param count
		 *            the count to set
		 */
		public void setCount(Integer count) {
			this.count = count;
		}

		/**
		 * 图片列表
		 * 
		 * @return the picList
		 */
		public PicList getPicList() {
			return picList;
		}

		/**
		 * 图片列表
		 * 
		 * @param picList
		 *            the picList to set
		 */
		public void setPicList(PicList picList) {
			this.picList = picList;
		}

		/*
		 * JSON字符串
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return new Gson().toJson(this);
		}

	}

	/**
	 * 图片列表
	 * 
	 * @author alex
	 *
	 */
	public static class PicList {

		private PicListItem[] item;// 图片项

		/**
		 * 图片项
		 * 
		 * @return the item
		 */
		public PicListItem[] getItem() {
			return item;
		}

		/**
		 * 图片项
		 * 
		 * @param item
		 *            the item to set
		 */
		public void setItem(PicListItem[] item) {
			this.item = item;
		}

	}

	/**
	 * 图片项
	 * 
	 * @author alex
	 *
	 */
	public static class PicListItem {
		private String picMd5Sum;// 图片的MD5值，开发者若需要，可用于验证接收到图片

		/**
		 * 图片的MD5值，开发者若需要，可用于验证接收到图片
		 * 
		 * @return the picMd5Sum
		 */
		public String getPicMd5Sum() {
			return picMd5Sum;
		}

		/**
		 * 图片的MD5值，开发者若需要，可用于验证接收到图片
		 * 
		 * @param picMd5Sum
		 *            the picMd5Sum to set
		 */
		public void setPicMd5Sum(String picMd5Sum) {
			this.picMd5Sum = picMd5Sum;
		}

	}

	/**
	 * @return the sendPicsInfo
	 */
	public SendPicsInfo getSendPicsInfo() {
		return sendPicsInfo;
	}

	/**
	 * @param sendPicsInfo
	 *            the sendPicsInfo to set
	 */
	public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
		this.sendPicsInfo = sendPicsInfo;
	}

}
