package com.shanli.weixin.mp.recv.event;

/**
 * 上报地理位置事件
 * 用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置，公众号可以在公众平台网站中修改以上设置。上报地理位置时，微信会将上报地理位置事件推送到开发者填写的URL。
 * 
 * @author alex
 *
 */
public class MsgEventLocation extends MsgEvent {
	private Double latitude;// 地理位置纬度
	private Double longitude;// 地理位置经度
	private Double precision;// 地理位置精度

	/**
	 * 地理位置纬度
	 * 
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 地理位置纬度
	 * 
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 地理位置经度
	 * 
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * 地理位置经度
	 * 
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 地理位置精度
	 * 
	 * @return the precision
	 */
	public Double getPrecision() {
		return precision;
	}

	/**
	 * 地理位置精度
	 * 
	 * @param precision
	 *            the precision to set
	 */
	public void setPrecision(Double precision) {
		this.precision = precision;
	}

}
