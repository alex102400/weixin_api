package com.shanli.weixin.open;

import java.io.Serializable;

import com.shanli.weixin.open.resp.AuthorizerAccessToken;
import com.shanli.weixin.open.resp.ComponentAccessToken;
import com.shanli.weixin.open.resp.PreAuthCode;
import com.shanli.weixin.util.storage.Storage;

/**
 * 开放平台运行时数据。 主要数据项包括ComponentAccessToken以及各个公众号的AccessToken这些存在有效期且存在刷新次数限制的对象。
 * 默认使用磁盘文件存储/weixin_api_runtime，生产环境中建议配置为Db存储。
 * 
 * @author alex
 *
 */
public class OpenApiRuntime implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -447921496732203086L;
	// 由开放平台主动推送过来的ticket
	private String componentVerifyTicket;
	// 开放平台AccessToken
	private ComponentAccessToken componentAccessToken;
	// 预授权码
	private PreAuthCode preAuthCode;

	/**
	 * 存储器
	 */
	private transient Storage storage;

	public OpenApiRuntime(Storage storage) {
		this.storage = storage;
		// 加载自己
		loadThis();
	}

	/**
	 * 由微信平台每10分钟提供的ticket。获取component_access_token时使用。
	 * 
	 * @param ticket
	 */
	public void setComponentVerifyTicket(String ticket) {
		this.componentVerifyTicket = ticket;

		// 保存
		saveThis();

	}

	/**
	 * 公众平台AccessToken。有效期2小时。
	 * 
	 * @param componentAccessToken
	 */
	public void setComponentAccessToken(ComponentAccessToken componentAccessToken) {
		this.componentAccessToken = componentAccessToken;

		// 保存
		saveThis();
	}

	/**
	 * 预授权码。
	 * 
	 * @param preAuthCode
	 */
	public void setPreAuthCode(PreAuthCode preAuthCode) {
		this.preAuthCode = preAuthCode;

		// 保存
		saveThis();

	}

	/**
	 * 移除公众号令牌。例如公众号取消授权。
	 * 
	 * @param mpAppid
	 */
	public void removeMpAuthorizerToken(String mpAppid) {
		// 移除
		storage.remove(mpAppid);
	}

	/**
	 * 保存公众号令牌。例如公众号授权或更新授权。
	 * 
	 * @param mpAppid
	 * @param mpAccessToken
	 */
	public void putMpAuthorizerToken(String mpAppid, AuthorizerAccessToken mpAccessToken) {

		// 保存
		storage.save(mpAppid, mpAccessToken);

	}

	/**
	 * 由微信平台每10分钟提供的ticket，用于获取component_access_token
	 * 
	 * @return
	 */
	public String getComponentVerifyTicket() {
		// 加载
		loadThis();

		return componentVerifyTicket;
	}

	/**
	 * 用于调用微信平台的token，有效期2小时，应当在过期前主动更新。
	 * 
	 * @return
	 */
	public ComponentAccessToken getComponentAccessToken() {
		// 加载
		loadThis();

		return componentAccessToken;
	}

	/**
	 * 预授权码。
	 * 
	 * @return
	 */
	public PreAuthCode getPreAuthCode() {
		// 加载
		loadThis();

		return preAuthCode;
	}

	/**
	 * 获取公众号令牌
	 * 
	 * @param mpAppId
	 *            公众号ID
	 * @return the mpAuthorizerToken
	 */
	public AuthorizerAccessToken getMpAuthorizerToken(String mpAppId) {
		return storage.get(mpAppId, AuthorizerAccessToken.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(4094);

		for (String key : storage.keys()) {
			sb.append("\n");
			sb.append(key);
			sb.append(" ");
			sb.append(storage.get(key, Object.class));
		}

		return sb.toString();
	}

	private void saveThis() {
		storage.save(this.getClass().getName(), this);
	}

	private void loadThis() {
		OpenApiRuntime instance = storage.get(this.getClass().getName(), this.getClass());
		if (instance == null) {
			return;
		}
		this.componentAccessToken = instance.componentAccessToken;
		this.componentVerifyTicket = instance.componentVerifyTicket;
		this.preAuthCode = instance.preAuthCode;
	}
}
