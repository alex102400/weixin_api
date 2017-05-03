package com.shanli.weixin.mp.resp.datacube;

import com.google.gson.annotations.SerializedName;

/**
 * 上行消息统计
 * 
 * @author alex
 *
 */
public class UpMsgCount {
	@SerializedName("ref_date")
	private String refDate;
	@SerializedName("msg_type")
	private Integer msgType;
	@SerializedName("msg_user")
	private Integer msgUser;
	@SerializedName("msg_count")
	private Integer msgCount;
	/**
	 * @return the refDate
	 */
	public String getRefDate() {
		return refDate;
	}
	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}
	/**
	 * @return the msgType
	 */
	public Integer getMsgType() {
		return msgType;
	}
	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	/**
	 * @return the msgUser
	 */
	public Integer getMsgUser() {
		return msgUser;
	}
	/**
	 * @param msgUser the msgUser to set
	 */
	public void setMsgUser(Integer msgUser) {
		this.msgUser = msgUser;
	}
	/**
	 * @return the msgCount
	 */
	public Integer getMsgCount() {
		return msgCount;
	}
	/**
	 * @param msgCount the msgCount to set
	 */
	public void setMsgCount(Integer msgCount) {
		this.msgCount = msgCount;
	}
	
	
}
