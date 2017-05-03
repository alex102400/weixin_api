package com.shanli.weixin.mp.recv;

/**
 * 语音消息
 * 
 * @author alex
 *
 */
public class UserMsgVoice extends UserMsg {
	/**
	 * 语音格式，如amr，speex等
	 */
	private String format;
	/**
	 * 媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;

	/**
	 * 语音识别结果。开通选项才有。
	 */
	private String recognition;

	/**
	 * 媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 媒体id，可以调用多媒体文件下载接口拉取数据
	 * 
	 * @param mediaId
	 *            the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * 语音格式，如amr，speex等
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 语音格式，如amr，speex等
	 * 
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 语音识别结果。开通选项才有。
	 * 
	 * @return the recognition
	 */
	public String getRecognition() {
		return recognition;
	}

	/**
	 * 语音识别结果。开通选项才有。
	 * 
	 * @param recognition
	 *            the recognition to set
	 */
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

}
