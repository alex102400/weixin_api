package com.shanli.weixin.open.event;

import com.google.gson.Gson;

/**
 * 公众开放平台授权事件。 全部由微信平台在事件发生时主动请求，直接响应success即可。 具体包括安全凭证、授权、授权更新、授权取消事件。
 * 
 * @author alex
 *
 */
public class OpenEvent {
	private String appId;
	private Long createTime;// 时间戳
	private OpenEventTypeEnum infoType;

	/**
	 * 开放平台应用ID即componentAppid
	 * @return
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 开放平台应用ID即componentAppid
	 * @param appId
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 事件unix时间戳
	 * @return
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * 事件unix时间戳
	 * @param createTime
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * 事件信息类型
	 * @return
	 */
	public OpenEventTypeEnum getInfoType() {
		return infoType;
	}

	/**
	 * 事件信息类型
	 * @param infoType
	 */
	public void setInfoType(OpenEventTypeEnum infoType) {
		this.infoType = infoType;
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
