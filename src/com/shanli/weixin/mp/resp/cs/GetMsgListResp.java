package com.shanli.weixin.mp.resp.cs;

import com.shanli.weixin.bean.BaseResp;
/**
 * 客服聊天记录
 * @author alex
 *
 */
public class GetMsgListResp extends BaseResp {
	private Long number;
	private Long msgid;
	private Record[] recordlist;
	public static class Record{
		private String worker;//	完整客服帐号，格式为：帐号前缀@公众号微信号
		private String openid;//	用户标识
		private Integer opercode;//	操作码，2002（客服发送信息），2003（客服接收消息）
		private String text;//	聊天记录
		private Long time;//	操作时间，unix时间戳
		/**完整客服帐号，格式为：帐号前缀@公众号微信号
		 * @return the worker
		 */
		public String getWorker() {
			return worker;
		}
		/**完整客服帐号，格式为：帐号前缀@公众号微信号
		 * @param worker the worker to set
		 */
		public void setWorker(String worker) {
			this.worker = worker;
		}
		/**用户标识
		 * @return the openid
		 */
		public String getOpenid() {
			return openid;
		}
		/**用户标识
		 * @param openid the openid to set
		 */
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		/**操作码，2002（客服发送信息），2003（客服接收消息）
		 * @return the opercode
		 */
		public Integer getOpercode() {
			return opercode;
		}
		/**操作码，2002（客服发送信息），2003（客服接收消息）
		 * @param opercode the opercode to set
		 */
		public void setOpercode(Integer opercode) {
			this.opercode = opercode;
		}
		/**聊天记录
		 * @return the text
		 */
		public String getText() {
			return text;
		}
		/**聊天记录
		 * @param text the text to set
		 */
		public void setText(String text) {
			this.text = text;
		}
		/**操作时间，unix时间戳
		 * @return the time
		 */
		public Long getTime() {
			return time;
		}
		/**操作时间，unix时间戳
		 * @param time the time to set
		 */
		public void setTime(Long time) {
			this.time = time;
		}
		
	}
	/**请求的number(10000)和返回的number(10000)一样，该时间段可能还有聊天记录未获取，将msgid（20165258）填进下次请求中；
	 * @return the number
	 */
	public Long getNumber() {
		return number;
	}
	/**请求的number(10000)和返回的number(10000)一样，该时间段可能还有聊天记录未获取，将msgid（20165258）填进下次请求中；
	 * @param number the number to set
	 */
	public void setNumber(Long number) {
		this.number = number;
	}
	/**
	 * @return the msgid
	 */
	public Long getMsgid() {
		return msgid;
	}
	/**
	 * @param msgid the msgid to set
	 */
	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}
	/**
	 * @return the recordlist
	 */
	public Record[] getRecordlist() {
		return recordlist;
	}
	/**
	 * @param recordlist the recordlist to set
	 */
	public void setRecordlist(Record[] recordlist) {
		this.recordlist = recordlist;
	}
}
