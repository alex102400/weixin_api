package com.shanli.weixin.bean;

import java.util.Hashtable;

/**
 * 响应码定义
 * 
 * @author alex
 *
 */
public class RespCodes {

	/**
	 * 不合法的调用凭证
	 */
	public static final Integer INVALID_CREDENTIAL = 40001;
	/**
	 * 不合法的grant_type
	 */
	public static final Integer INVALID_GRANT_TYPE = 40002;
	/**
	 * 不合法的OpenID
	 */
	public static final Integer INVALID_OPENID = 40003;
	/**
	 * 不合法的媒体文件类型
	 */
	public static final Integer INVALID_MEDIA_TYPE = 40004;
	/**
	 * 不合法的media_id
	 */
	public static final Integer INVALID_MEDIA_ID = 40007;
	/**
	 * 不合法的message_type
	 */
	public static final Integer INVALID_MESSAGE_TYPE = 40008;
	/**
	 * 不合法的图片大小
	 */
	public static final Integer INVALID_IMAGE_SIZE = 40009;
	/**
	 * 不合法的语音大小
	 */
	public static final Integer INVALID_VOICE_SIZE = 40010;
	/**
	 * 不合法的视频大小
	 */
	public static final Integer INVALID_VIDEO_SIZE = 40011;
	/**
	 * 不合法的缩略图大小
	 */
	public static final Integer INVALID_THUMB_SIZE = 40012;
	/**
	 * 不合法的AppID
	 */
	public static final Integer INVALID_APPID = 40013;
	/**
	 * 不合法的access_token
	 */
	public static final Integer INVALID_ACCESS_TOKEN = 40014;
	/**
	 * 不合法的菜单类型
	 */
	public static final Integer INVALID_MENU_TYPE = 40015;
	/**
	 * 不合法的菜单按钮个数
	 */
	public static final Integer INVALID_BUTTON_SIZE = 40016;
	/**
	 * 不合法的按钮类型
	 */
	public static final Integer INVALID_BUTTON_TYPE = 40017;
	/**
	 * 不合法的按钮名称长度
	 */
	public static final Integer INVALID_BUTTON_NAME_SIZE = 40018;
	/**
	 * 不合法的按钮KEY长度
	 */
	public static final Integer INVALID_BUTTON_KEY_SIZE = 40019;
	/**
	 * 不合法的url长度
	 */
	public static final Integer INVALID_BUTTON_URL_SIZE = 40020;
	/**
	 * 不合法的子菜单按钮个数
	 */
	public static final Integer INVALID_SUB_BUTTON_SIZE = 40023;
	/**
	 * 不合法的子菜单类型
	 */
	public static final Integer INVALID_SUB_BUTTON_TYPE = 40024;
	/**
	 * 不合法的子菜单按钮名称长度
	 */
	public static final Integer INVALID_SUB_BUTTON_NAME_SIZE = 40025;
	/**
	 * 不合法的子菜单按钮KEY长度
	 */
	public static final Integer INVALID_SUB_BUTTON_KEY_SIZE = 40026;
	/**
	 * 不合法的子菜单按钮url长度
	 */
	public static final Integer INVALID_SUB_BUTTON_URL_SIZE = 40027;
	/**
	 * 不合法或已过期的code
	 */
	public static final Integer INVALID_CODE = 40029;
	/**
	 * 不合法的refresh_token
	 */
	public static final Integer INVALID_REFRESH_TOKEN = 40030;
	/**
	 * 不合法的template_id长度
	 */
	public static final Integer INVALID_TEMPLATE_ID_SIZE = 40036;
	/**
	 * 不合法的template_id
	 */
	public static final Integer INVALID_TEMPLATE_ID = 40037;
	/**
	 * 不合法的url长度
	 */
	public static final Integer INVALID_URL_SIZE = 40039;
	/**
	 * 不合法的url域名
	 */
	public static final Integer INVALID_URL_DOMAIN = 40048;
	/**
	 * 不合法的子菜单按钮url域名
	 */
	public static final Integer INVALID_SUB_BUTTON_URL_DOMAIN = 40054;
	/**
	 * 不合法的菜单按钮url域名
	 */
	public static final Integer INVALID_BUTTON_URL_DOMAIN = 40055;
	/**
	 * 不合法的url
	 */
	public static final Integer INVALID_URL = 40066;
	/**
	 * 缺失access_token参数
	 */
	public static final Integer ACCESS_TOKEN_MISSING = 41001;
	/**
	 * 缺失appid参数
	 */
	public static final Integer APPID_MISSING = 41002;
	/**
	 * 缺失refresh_token参数
	 */
	public static final Integer REFRESH_TOKEN_MISSING = 41003;
	/**
	 * 缺失secret参数
	 */
	public static final Integer APPSECRET_MISSING = 41004;
	/**
	 * 缺失二进制媒体文件
	 */
	public static final Integer MEDIA_DATA_MISSING = 41005;
	/**
	 * 缺失media_id参数
	 */
	public static final Integer MEDIA_ID_MISSING = 41006;
	/**
	 * 缺失子菜单数据
	 */
	public static final Integer SUB_MENU_DATA_MISSING = 41007;
	/**
	 * 缺失code参数
	 */
	public static final Integer MISSING_CODE = 41008;
	/**
	 * 缺失openid参数
	 */
	public static final Integer MISSING_OPENID = 41009;
	/**
	 * 缺失url参数
	 */
	public static final Integer MISSING_URL = 41010;
	/**
	 * access_token超时
	 */
	public static final Integer ACCESS_TOKEN_EXPIRED = 42001;
	/**
	 * refresh_token超时
	 */
	public static final Integer REFRESH_TOKEN_EXPIRED = 42002;
	/**
	 * code超时
	 */
	public static final Integer CODE_EXPIRED = 42003;
	/**
	 * 需要使用GET方法请求
	 */
	public static final Integer REQUIRE_GET_METHOD = 43001;
	/**
	 * 需要使用POST方法请求
	 */
	public static final Integer REQUIRE_POST_METHOD = 43002;
	/**
	 * 需要使用HTTPS
	 */
	public static final Integer REQUIRE_HTTPS = 43003;
	/**
	 * 需要订阅关系
	 */
	public static final Integer REQUIRE_SUBSCRIBE = 43004;
	/**
	 * 空白的二进制数据
	 */
	public static final Integer EMPTY_MEDIA_DATA = 44001;
	/**
	 * 空白的POST数据
	 */
	public static final Integer EMPTY_POST_DATA = 44002;
	/**
	 * 空白的news数据
	 */
	public static final Integer EMPTY_NEWS_DATA = 44003;
	/**
	 * 空白的内容
	 */
	public static final Integer EMPTY_CONTENT = 44004;
	/**
	 * 空白的列表
	 */
	public static final Integer EMPTY_LIST_SIZE = 44005;
	/**
	 * 二进制文件超过限制
	 */
	public static final Integer MEDIA_SIZE_OUT_OF_LIMIT = 45001;
	/**
	 * content参数超过限制
	 */
	public static final Integer CONTENT_SIZE_OUT_OF_LIMIT = 45002;
	/**
	 * title参数超过限制
	 */
	public static final Integer TITLE_SIZE_OUT_OF_LIMIT = 45003;
	/**
	 * description参数超过限制
	 */
	public static final Integer DESCRIPTION_SIZE_OUT_OF_LIMIT = 45004;
	/**
	 * url参数长度超过限制
	 */
	public static final Integer URL_SIZE_OUT_OF_LIMIT = 45005;
	/**
	 * picurl参数超过限制
	 */
	public static final Integer PICURL_SIZE_OUT_OF_LIMIT = 45006;
	/**
	 * 播放时间超过限制（语音为60s最大）
	 */
	public static final Integer PLAYTIME_OUT_OF_LIMIT = 45007;
	/**
	 * article参数超过限制
	 * 
	 */
	public static final Integer ARTICLE_SIZE_OUT_OF_LIMIT = 45008;
	/**
	 * 接口调动频率超过限制
	 */
	public static final Integer API_FREQ_OUT_OF_LIMIT = 45009;
	/**
	 * 建立菜单被限制
	 */
	public static final Integer CREATE_MENU_LIMIT = 45010;
	/**
	 * 频率限制
	 * 
	 */
	public static final Integer API_LIMIT = 45011;
	/**
	 * 模板大小超过限制
	 */
	public static final Integer TEMPLATE_SIZE_OUT_OF_LIMIT = 45012;
	/**
	 * 不能修改默认组
	 */
	public static final Integer CANT_MODIFY_SYS_GROUP = 45016;
	/**
	 * 修改组名过长
	 */
	public static final Integer GROUP_NAME_TOO_LONG = 45017;
	/**
	 * 组数量过多
	 */
	public static final Integer TOO_MANY_GROUP_NOW = 45018;
	/**
	 * 接口未授权
	 */
	public static final Integer API_UNAUTHORIZED = 50001;

	/**
	 * 成功
	 */
	public static final Integer OK = 0;

	/**
	 * 微信平台繁忙，请稍候再试
	 */
	public static final Integer BUSY = -1;

	/**
	 * 响应代码描述(码值,说明)
	 */
	public static final Hashtable<Integer, String> CODE_DESCS = new Hashtable<Integer, String>(512);

	static {
		CODE_DESCS.put(OK, "成功");
		CODE_DESCS.put(BUSY, "微信平台繁忙，请稍候再试");
		CODE_DESCS.put(TOO_MANY_GROUP_NOW, "组数量过多");
		CODE_DESCS.put(GROUP_NAME_TOO_LONG, "修改组名过长");
		CODE_DESCS.put(CANT_MODIFY_SYS_GROUP, "不能修改默认组");
		CODE_DESCS.put(TEMPLATE_SIZE_OUT_OF_LIMIT, "模板大小超过限制");
		CODE_DESCS.put(API_LIMIT, "频率限制");
		CODE_DESCS.put(CREATE_MENU_LIMIT, "建立菜单被限制");
		CODE_DESCS.put(API_FREQ_OUT_OF_LIMIT, "接口调动频率超过限制");
		CODE_DESCS.put(ARTICLE_SIZE_OUT_OF_LIMIT, "article参数超过限制");
		CODE_DESCS.put(PLAYTIME_OUT_OF_LIMIT, "播放时间超过限制（语音为60s最大）");
		CODE_DESCS.put(PICURL_SIZE_OUT_OF_LIMIT, "picurl参数超过限制");
		CODE_DESCS.put(URL_SIZE_OUT_OF_LIMIT, "url参数长度超过限制");
		CODE_DESCS.put(DESCRIPTION_SIZE_OUT_OF_LIMIT, "description参数超过限制");
		CODE_DESCS.put(TITLE_SIZE_OUT_OF_LIMIT, "title参数超过限制");
		CODE_DESCS.put(CONTENT_SIZE_OUT_OF_LIMIT, "content参数超过限制");
		CODE_DESCS.put(MEDIA_SIZE_OUT_OF_LIMIT, "二进制文件超过限制");
		CODE_DESCS.put(EMPTY_LIST_SIZE, "空白的列表");
		CODE_DESCS.put(EMPTY_CONTENT, "空白的内容");
		CODE_DESCS.put(EMPTY_NEWS_DATA, "空白的news数据");
		CODE_DESCS.put(EMPTY_POST_DATA, "空白的POST数据");
		CODE_DESCS.put(EMPTY_MEDIA_DATA, "空白的二进制数据");
		CODE_DESCS.put(REQUIRE_SUBSCRIBE, "需要订阅关系");
		CODE_DESCS.put(REQUIRE_HTTPS, "需要使用HTTPS");
		CODE_DESCS.put(REQUIRE_POST_METHOD, "需要使用POST方法请求");
		CODE_DESCS.put(REQUIRE_GET_METHOD, "需要使用GET方法请求");
		CODE_DESCS.put(CODE_EXPIRED, "code超时");
		CODE_DESCS.put(REFRESH_TOKEN_EXPIRED, "refresh_token超时");
		CODE_DESCS.put(ACCESS_TOKEN_EXPIRED, "access_token超时");
		CODE_DESCS.put(MISSING_URL, "缺失url参数");
		CODE_DESCS.put(MISSING_OPENID, "缺失openid参数");
		CODE_DESCS.put(MISSING_CODE, "缺失code参数");
		CODE_DESCS.put(SUB_MENU_DATA_MISSING, "缺失子菜单数据");
		CODE_DESCS.put(MEDIA_ID_MISSING, "缺失media_id参数");
		CODE_DESCS.put(MEDIA_DATA_MISSING, "缺失二进制媒体文件");
		CODE_DESCS.put(APPSECRET_MISSING, "缺失secret参数");
		CODE_DESCS.put(REFRESH_TOKEN_MISSING, "缺失refresh_token参数");
		CODE_DESCS.put(APPID_MISSING, "缺失appid参数");
		CODE_DESCS.put(ACCESS_TOKEN_MISSING, "缺失access_token参数");
		CODE_DESCS.put(INVALID_URL, "不合法的url");
		CODE_DESCS.put(INVALID_BUTTON_URL_DOMAIN, "不合法的菜单按钮url域名");
		CODE_DESCS.put(INVALID_SUB_BUTTON_URL_DOMAIN, "不合法的子菜单按钮url域名");
		CODE_DESCS.put(INVALID_URL_DOMAIN, "不合法的url域名");
		CODE_DESCS.put(INVALID_URL_SIZE, "不合法的url长度");
		CODE_DESCS.put(INVALID_TEMPLATE_ID, "不合法的template_id");
		CODE_DESCS.put(INVALID_TEMPLATE_ID_SIZE, "不合法的template_id长度");
		CODE_DESCS.put(INVALID_REFRESH_TOKEN, "不合法的refresh_token");
		CODE_DESCS.put(INVALID_CODE, "不合法或已过期的code");
		CODE_DESCS.put(INVALID_SUB_BUTTON_URL_SIZE, "不合法的子菜单按钮url长度");
		CODE_DESCS.put(INVALID_SUB_BUTTON_KEY_SIZE, "不合法的子菜单按钮KEY长度");
		CODE_DESCS.put(INVALID_SUB_BUTTON_NAME_SIZE, "不合法的子菜单按钮名称长度");
		CODE_DESCS.put(INVALID_SUB_BUTTON_TYPE, "不合法的子菜单类型");
		CODE_DESCS.put(INVALID_SUB_BUTTON_SIZE, "不合法的子菜单按钮个数");
		CODE_DESCS.put(INVALID_BUTTON_URL_SIZE, "不合法的url长度");
		CODE_DESCS.put(INVALID_BUTTON_KEY_SIZE, "不合法的按钮KEY长度");
		CODE_DESCS.put(INVALID_BUTTON_NAME_SIZE, "不合法的按钮名称长度");
		CODE_DESCS.put(INVALID_BUTTON_TYPE, "不合法的按钮类型");
		CODE_DESCS.put(INVALID_BUTTON_SIZE, "不合法的菜单按钮个数");
		CODE_DESCS.put(INVALID_MENU_TYPE, "不合法的菜单类型");
		CODE_DESCS.put(INVALID_ACCESS_TOKEN, "不合法的access_token");
		CODE_DESCS.put(INVALID_APPID, "不合法的AppID");
		CODE_DESCS.put(INVALID_THUMB_SIZE, "不合法的缩略图大小");
		CODE_DESCS.put(INVALID_VIDEO_SIZE, "不合法的视频大小");
		CODE_DESCS.put(INVALID_VOICE_SIZE, "不合法的语音大小");
		CODE_DESCS.put(INVALID_IMAGE_SIZE, "不合法的图片大小");
		CODE_DESCS.put(INVALID_MESSAGE_TYPE, "不合法的message_type");
		CODE_DESCS.put(INVALID_MEDIA_ID, "不合法的media_id");
		CODE_DESCS.put(INVALID_MEDIA_TYPE, "不合法的媒体文件类型");
		CODE_DESCS.put(INVALID_OPENID, "不合法的OpenID");
		CODE_DESCS.put(INVALID_GRANT_TYPE, "不合法的grant_type");
		CODE_DESCS.put(INVALID_CREDENTIAL, "不合法的调用凭证");
	}
}
