package com.shanli.weixin.open.event;

/**
 * 公众号更新授权
 * 
 * @author alex
 *
 */
public class OpenEventUpdateAuthorized extends OpenEventAuthorized {
	public OpenEventUpdateAuthorized() {
		this.setInfoType(OpenEventTypeEnum.updateauthorized);
	}
}
