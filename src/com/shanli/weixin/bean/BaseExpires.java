package com.shanli.weixin.bean;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * 有效期信息基类。
 * 
 * @author alex
 *
 */
public class BaseExpires extends BaseResp implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5888339116929378654L;

	/**
	 * 过期时间（秒）
	 */
	@SerializedName("expires_in")
	private Integer expiresIn;

	/**
	 * 更新时间戳(秒值)
	 */
	private Long timestamp;

	/**
	 * 新对象的时间戳默认为当前时间。
	 */
	public BaseExpires() {
		this.timestamp=System.currentTimeMillis();
	}

	/**
	 * 计算有效期剩余分钟数
	 * 
	 * @return 有效期剩余分钟数。-1表示已过期。
	 */
	public long countExpiresMinutes() {
		if (expiresIn == null) {
			return -1;
		}
		return (expiresIn - ((System.currentTimeMillis() - this.timestamp) / 1000)) / 60;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
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
