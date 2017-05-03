package com.shanli.weixin.mp.recv;

import com.google.gson.Gson;
import com.shanli.weixin.bean.BaseResp;

/**
 * 微信消息基类
 * 
 * @author alex
 *
 */
public class UserMsg extends BaseResp {
	private String openid;
	private String appid;
	private UserMsgTypeEnum type;
	private String msgType;
	private String toUserName;
	private String fromUserName;
	private Integer createTime;
	private String msgId;

	/**
	 * 微信用户的OpenID（仅开放平台模式）
	 * 
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 微信用户的OpenID（仅开放平台模式）
	 * 
	 * @param openid
	 *            the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 公众号mpAppId（仅开放平台模式）
	 * 
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * 公众号mpAppId（仅开放平台模式）
	 * 
	 * @param appid
	 *            the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * 消息类型Enum
	 * 
	 * @param type
	 */
	public void setType(UserMsgTypeEnum type) {
		this.type = type;
	}

	/**
	 * 消息类型Enum
	 * 
	 * @return the type
	 */
	public UserMsgTypeEnum getType() {
		return type;
	}

	/**
	 * 公众号原始ID
	 * 
	 * @return the toUserName
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * 公众号原始ID
	 * 
	 * @param toUserName
	 *            the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * 发送方帐号（微信用户OpenID）
	 * 
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * 发送方帐号（微信用户OpenID）
	 * 
	 * @param fromUserName
	 *            the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * 消息创建时间 unix_timestamp
	 * 
	 * @return the createTime
	 */
	public Integer getCreateTime() {
		return createTime;
	}

	/**
	 * 消息创建时间 unix_timestamp
	 * 
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	/**
	 * 消息类型
	 * 
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * 消息类型
	 * 
	 * @param msgType
	 *            the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * 消息id
	 * 
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * 消息id
	 * 
	 * @param msgId
	 *            the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
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
