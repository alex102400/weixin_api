package com.shanli.weixin.mp.resp.user;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 
 * @author alex
 *
 */
public class UserGetResp extends BaseResp {
	private Integer count;// 这次获取的粉丝数量

	@SerializedName("next_openid")
	private String nextOpenid;// 拉取列表最后一个用户的openid

	private Data data;

	public static class Data {
		private String[] openid;

		/**
		 * @return the openid
		 */
		public String[] getOpenid() {
			return openid;
		}

		/**
		 * @param openid
		 *            the openid to set
		 */
		public void setOpenid(String[] openid) {
			this.openid = openid;
		}

	}

	/**
	 * 这次获取的粉丝数量
	 * 
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 这次获取的粉丝数量
	 * 
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * 拉取列表最后一个用户的openid
	 * 
	 * @return the nextOpenid
	 */
	public String getNextOpenid() {
		return nextOpenid;
	}

	/**
	 * 拉取列表最后一个用户的openid
	 * 
	 * @param nextOpenid
	 *            the nextOpenid to set
	 */
	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}

	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Data data) {
		this.data = data;
	}
}
