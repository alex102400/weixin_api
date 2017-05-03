package com.shanli.weixin.mp.recv.event;

import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 公众号事件类型
 * 
 * @author alex
 *
 */
public enum MsgEventTypeEnum {
	/**
	 * 新用户关注/扫码关注。
	 */
	subscribe(MsgEventSubscribe.class),
	/**
	 * 取消关注。
	 */
	unsubscribe(MsgEvent.class),
	/**
	 * 已关注用户扫码
	 */
	SCAN(MsgEventScan.class),
	/**
	 * 位置上报（用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置）
	 */
	LOCATION(MsgEventLocation.class),
	/**
	 * 消息群发结果事件
	 */
	MASSSENDJOBFINISH(MsgEventMassSendJobFinish.class),
	/**
	 * 模板消息发送结果事件
	 */
	TEMPLATESENDJOBFINISH(MsgEventTemplateSendJobjFinish.class),
	/**
	 * 菜单点击触发
	 */
	CLICK(MsgEventMenuClick.class),
	/**
	 * 菜单链接跳转
	 */
	VIEW(MsgEventMenuView.class),
	/**
	 * 菜单扫码推事件
	 */
	scancode_push(MsgEventMenuScanCode.class),
	/**
	 * 菜单扫码推事件且弹出“消息接收中”提示框事件
	 */
	scancode_waitmsg(MsgEventMenuScanCode.class),
	/**
	 * 菜单弹出系统拍照发图的事件
	 */
	pic_sysphoto(MsgEventMenuPic.class),
	/**
	 * 菜单弹出拍照或者相册发图的事件
	 */
	pic_photo_or_album(MsgEventMenuPic.class),
	/**
	 * 菜单弹出微信相册发图器的事件
	 */
	pic_weixin(MsgEventMenuPic.class),
	/**
	 * 菜单弹出地理位置选择器的事件
	 */
	location_select(MsgEventMenuLocation.class),

	/**
	 * 资质认证成功（此时立即获得接口权限）
	 */
	qualification_verify_success(MsgEventQualificationVerifySuccess.class),
	/**
	 * 资质认证失败
	 */
	qualification_verify_fail(MsgEventQualificationVerifyFail.class),
	/**
	 * 名称认证成功（即命名成功）
	 */
	naming_verify_success(MsgEventNamingVerifySuccess.class),
	/**
	 * 名称认证失败（这时虽然客户端不打勾，但仍有接口权限）
	 */
	naming_verify_fail(MsgEventNamingVerifyFail.class),

	/**
	 * 年审通知
	 */
	annual_renew(MsgEventAnnualRenew.class),
	/**
	 * 认证过期失效通知
	 */
	verify_expired(MsgEventVerifyExpired.class),
	/**
	 * 客服会话建立
	 */
	kf_create_session(MsgEventKfCreateSession.class);

	private Class<? extends UserMsg> clazz;

	/**
	 * 实现类。
	 * 
	 * @return
	 */
	public Class<? extends UserMsg> getClazz() {
		return this.clazz;
	}

	private MsgEventTypeEnum(Class<? extends UserMsg> clazz) {
		this.clazz = clazz;
	}
}
