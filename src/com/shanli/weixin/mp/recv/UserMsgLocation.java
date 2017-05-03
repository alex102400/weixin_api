package com.shanli.weixin.mp.recv;

/**
 * 位置消息
 * 
 * @author alex
 *
 */
public class UserMsgLocation extends UserMsg {
	private Double location_X;// 地理位置纬度
	private Double location_Y;// 地理位置经度
	private Integer scale;// 地图缩放大小
	private String label;// 地理位置信息
	private String poiname;// 朋友圈POI的名字，可能为空

	/**
	 * 地理位置纬度
	 * 
	 * @return the location_X
	 */
	public Double getLocation_X() {
		return location_X;
	}

	/**
	 * 地理位置纬度
	 * 
	 * @param location_X
	 *            the location_X to set
	 */
	public void setLocation_X(Double location_X) {
		this.location_X = location_X;
	}

	/**
	 * 地理位置经度
	 * 
	 * @return the location_Y
	 */
	public Double getLocation_Y() {
		return location_Y;
	}

	/**
	 * 地理位置经度
	 * 
	 * @param location_Y
	 *            the location_Y to set
	 */
	public void setLocation_Y(Double location_Y) {
		this.location_Y = location_Y;
	}

	/**
	 * 地图缩放大小
	 * 
	 * @return the scale
	 */
	public Integer getScale() {
		return scale;
	}

	/**
	 * 地图缩放大小
	 * 
	 * @param scale
	 *            the scale to set
	 */
	public void setScale(Integer scale) {
		this.scale = scale;
	}

	/**
	 * 地理位置信息
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 地理位置信息
	 * 
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 朋友圈POI的名字，可能为空
	 * 
	 * @return the poiname
	 */
	public String getPoiname() {
		return poiname;
	}

	/**
	 * 朋友圈POI的名字，可能为空
	 * 
	 * @param poiname
	 *            the poiname to set
	 */
	public void setPoiname(String poiname) {
		this.poiname = poiname;
	}

}
