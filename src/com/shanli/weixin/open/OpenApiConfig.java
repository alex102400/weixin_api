package com.shanli.weixin.open;

import java.io.File;

import com.shanli.weixin.WeixinConfig;
import com.shanli.weixin.util.storage.FileStorage;
import com.shanli.weixin.util.storage.Storage;

/**
 * 开放平台第三方应用的参数配置
 * 
 * @author alex
 *
 */
public class OpenApiConfig extends WeixinConfig {

	/**
	 * 开放平台应用ID。创建应用后微信开放平台生成。
	 */
	private String componentAppid;
	/**
	 * 开放平台消息校验Token。创建应用时自行填写。
	 */
	private String componentToken;
	/**
	 * 开放平台消息加解密Key。创建应用时自行填写,必须是43位。
	 */
	private String componentEncodingAesKey;

	/**
	 * 开放平台密钥。创建应用后扫码生成。
	 */
	private String componentAppSecret;

	/**
	 * 全网发布检测是否已通过
	 */
	private boolean componentPublishDetected = false;

	/**
	 * 全网发布检测的APPID
	 */
	private String componentPublishAppid;
	/**
	 * 全网发布检测的用户ID
	 */
	private String componentPublishUsername;

	/**
	 * 有效期信息提前更新的时间（分钟）。默认5分钟。
	 */
	private int expiresInfoUpdateBefore = 5;

	/**
	 * 工作线程池大小。默认16。
	 */
	private int workerThreadPoolSize = 16;

	/**
	 * 消息ID去重的缓存大小。默认2048。
	 */
	private int distinctMsgIdCacheSize = 2048;

	/**
	 * Runtime存储器，默认基于FileStorage在/weixin_api_runtime目录下。
	 */
	private Storage runtimeStorage = new FileStorage(new File("/weixin_api_runtime"));

	/**
	 * 开放平台应用ID。创建应用后微信开放平台生成。
	 * 
	 * @return
	 */
	public String getComponentAppid() {
		return componentAppid;
	}

	/**
	 * 开放平台应用ID。创建应用后微信开放平台生成。
	 * 
	 * @param componentAppid
	 */
	public void setComponentAppid(String componentAppid) {
		this.componentAppid = componentAppid;
	}

	/**
	 * 开放平台消息校验Token。创建应用时自行填写。
	 * 
	 * @return
	 */
	public String getComponentToken() {
		return componentToken;
	}

	/**
	 * 开放平台消息校验Token。创建应用时自行填写。
	 * 
	 * @param componentToken
	 */
	public void setComponentToken(String componentToken) {
		this.componentToken = componentToken;
	}

	/**
	 * 开放平台消息加解密Key。创建应用时自行填写,必须是43位。
	 * 
	 * @return
	 */
	public String getComponentEncodingAesKey() {
		return componentEncodingAesKey;
	}

	/**
	 * 开放平台消息加解密Key。创建应用时自行填写,必须是43位。
	 * 
	 * @param componentEncodingAesKey
	 */
	public void setComponentEncodingAesKey(String componentEncodingAesKey) {
		this.componentEncodingAesKey = componentEncodingAesKey;
	}

	/**
	 * 开放平台密钥。创建应用后扫码生成。
	 * 
	 * @return
	 */
	public String getComponentAppSecret() {
		return componentAppSecret;
	}

	/**
	 * 开放平台密钥。创建应用后扫码生成。
	 * 
	 * @param componentAppSecret
	 */
	public void setComponentAppSecret(String componentAppSecret) {
		this.componentAppSecret = componentAppSecret;
	}

	/**
	 * 工作线程池大小。默认16。
	 * 
	 * @return
	 */
	public int getWorkerThreadPoolSize() {
		return workerThreadPoolSize;
	}

	/**
	 * 工作线程池大小。默认16。
	 * 
	 * @param workerThreadPoolSize
	 */
	public void setWorkerThreadPoolSize(int workerThreadPoolSize) {
		this.workerThreadPoolSize = workerThreadPoolSize;
	}

	/**
	 * 到期前的更新开始时间（分钟）。默认5分钟。
	 * 
	 * @return the expiresInfoUpdateBefore
	 */
	public int getExpiresInfoUpdateBefore() {
		return expiresInfoUpdateBefore;
	}

	/**
	 * 到期前的更新开始时间（分钟）。默认5分钟。
	 * 
	 * @param expiresInfoUpdateBefore
	 *            the expiresInfoUpdateBefore to set
	 */
	public void setExpiresInfoUpdateBefore(int expiresInfoUpdateBefore) {
		this.expiresInfoUpdateBefore = expiresInfoUpdateBefore;
	}

	/**
	 * 消息ID去重的缓存大小。默认2048。
	 * 
	 * @return the distinctMsgIdCacheSize
	 */
	public int getDistinctMsgIdCacheSize() {
		return distinctMsgIdCacheSize;
	}

	/**
	 * 消息ID去重的缓存大小。默认2048。
	 * 
	 * @param distinctMsgIdCacheSize
	 *            the distinctMsgIdCacheSize to set
	 */
	public void setDistinctMsgIdCacheSize(int distinctMsgIdCacheSize) {
		this.distinctMsgIdCacheSize = distinctMsgIdCacheSize;
	}

	/**
	 * 全网发布检测的APPID
	 * 
	 * @return the componentPublishAppid
	 */
	public String getComponentPublishAppid() {
		return componentPublishAppid;
	}

	/**
	 * 全网发布检测的APPID
	 * 
	 * @param componentPublishAppid
	 *            the componentPublishAppid to set
	 */
	public void setComponentPublishAppid(String componentPublishAppid) {
		this.componentPublishAppid = componentPublishAppid;
	}

	/**
	 * 全网发布检测的用户ID
	 * 
	 * @return the componentPublishUsername
	 */
	public String getComponentPublishUsername() {
		return componentPublishUsername;
	}

	/**
	 * 全网发布检测的用户ID
	 * 
	 * @param componentPublishUsername
	 *            the componentPublishUsername to set
	 */
	public void setComponentPublishUsername(String componentPublishUsername) {
		this.componentPublishUsername = componentPublishUsername;
	}

	/**
	 * 全网发布检测是否已通过
	 * 
	 * @return the componentPublishDetected
	 */
	public boolean isComponentPublishDetected() {
		return componentPublishDetected;
	}

	/**
	 * 全网发布检测是否已通过
	 * 
	 * @param componentPublishDetected
	 *            the componentPublishDetected to set
	 */
	public void setComponentPublishDetected(boolean componentPublishDetected) {
		this.componentPublishDetected = componentPublishDetected;
	}

	/**
	 * Runtime存储器，默认基于FileStorage在/weixin_api_runtime目录下。
	 * 
	 * @return the runtimeStorage
	 */
	public Storage getRuntimeStorage() {
		return runtimeStorage;
	}

	/**
	 * Runtime存储器，默认基于FileStorage在/weixin_api_runtime目录下。
	 * 
	 * @param runtimeStorage
	 *            the runtimeStorage to set
	 */
	public void setRuntimeStorage(Storage runtimeStorage) {
		this.runtimeStorage = runtimeStorage;
	}

}
