package com.shanli.weixin.mp.recv.event;

import com.google.gson.Gson;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 事件消息。
 * 
 * @author alex
 *
 */
public class MsgEvent extends UserMsg {
	private String event;// 事件类型，subscribe(订阅)、unsubscribe(取消订阅)等
	private MsgEventTypeEnum eventType;

	/**
	 * 事件类型subscribe(订阅)、unsubscribe(取消订阅)等
	 * 
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * 事件类型subscribe(订阅)、unsubscribe(取消订阅)等
	 * 
	 * @param event
	 *            the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * 事件类型
	 * 
	 * @return the eventType
	 */
	public MsgEventTypeEnum getEventType() {
		return eventType;
	}

	/**
	 * 事件类型
	 * 
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(MsgEventTypeEnum eventType) {
		this.eventType = eventType;
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
