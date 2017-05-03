package com.shanli.weixin.bean;

import com.google.gson.Gson;

/**
 * 微信开放平台响应消息基类
 * 
 * @author alex
 *
 */
public class BaseResp {
	private Integer errcode;
	private String errmsg;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
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
