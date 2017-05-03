package com.shanli.weixin.open.resp;

/**
 * 公众号的选项信息，如：地理位置上报，语音识别开关，多客服开关。
 * 
 * @author alex
 *
 */
public enum AuthorizerOptionEnum {
	location_report("地理位置上报"), voice_recognize("语音识别"), customer_service("多客服");
	private String desc;

	AuthorizerOptionEnum(String desc) {
		this.desc = desc;
	}

	/**
	 * 说明
	 * 
	 * @return
	 */
	public String getDesc() {
		return desc;
	}

}
