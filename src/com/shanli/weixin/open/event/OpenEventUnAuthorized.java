package com.shanli.weixin.open.event;

/**
 * 公众号取消授权
 * 
 * @author alex
 *
 */
public class OpenEventUnAuthorized extends OpenEventMpAuthBase {
	public OpenEventUnAuthorized() {
		this.setInfoType(OpenEventTypeEnum.unauthorized);
	}
}
