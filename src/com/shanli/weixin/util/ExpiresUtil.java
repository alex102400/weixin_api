package com.shanli.weixin.util;

import com.shanli.weixin.bean.BaseExpires;
import com.shanli.weixin.bean.RespCodes;
import com.shanli.weixin.open.OpenApi;

/**
 * 有效期信息工具类。如AccessToken/Ticket等信息。
 * @author alex
 *
 */
public class ExpiresUtil {

	/**
	 * 检查有效期信息是否需要更新
	 * 
	 * @return
	 */
	public static boolean isNeedUpdate(BaseExpires expires) {
	
		// 信息不存在，过期时间为空，错误码不为0（成功）
		if (expires == null || expires.getExpiresIn() == null
				|| (expires.getErrcode() != null && !RespCodes.OK.equals(expires.getErrcode()))) {
			return true;
		}
		// 存活期不足
		if (expires.countExpiresMinutes() < OpenApi.getInstance().getConfig().getExpiresInfoUpdateBefore()) {
			return true;
		}
		return false;
	}
	
}
