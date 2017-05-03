package com.shanli.weixin.open.event;

/**
 * 开放平台授权事件Enum。 component_verify_ticket每10分钟推送一次的安全ticket。
 * unauthorized是取消授权，updateauthorized是更新授权，authorized是授权成功通知
 * 
 * @author alex
 *
 */
public enum OpenEventTypeEnum {
	component_verify_ticket(OpenEventTicket.class), unauthorized(OpenEventUnAuthorized.class), updateauthorized(
			OpenEventUpdateAuthorized.class), authorized(OpenEventAuthorized.class);

	private Class<? extends OpenEvent> clazz;

	/**
	 * 事件类。
	 * 
	 * @return
	 */
	public Class<? extends OpenEvent> getClazz() {
		return this.clazz;
	}

	private OpenEventTypeEnum(Class<? extends OpenEvent> clazz) {
		this.clazz = clazz;
	}

}
