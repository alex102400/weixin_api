package com.shanli.weixin.mp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 个性化菜单匹配规则。 matchrule共六个字段，均可为空，但不能全部为空，至少要有一个匹配信息是不为空的。
 * 
 * @author alex
 *
 */
public class Matchrule {
	/**
	 * 用户标签的id，可通过用户标签管理接口获取。创建规则时使用此字段。
	 */
	@SerializedName("tag_id")
	private String tagId;

	/**
	 * 用户组的ID。含义应该是与tagId一致，目前的文档中在菜单查询时返回时是叫groupId。
	 */
	@SerializedName("group_id")
	private String groupId;

	/**
	 * 性别：男（1）女（2），不填则不做匹配
	 */
	private Integer sex;
	/**
	 * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
	 */
	@SerializedName("client_platform_type")
	private Integer clientPlatformType;
	/**
	 * 国家信息，是用户在微信中设置的地区
	 */
	private String country;
	/**
	 * 省份信息
	 */
	private String province;
	/**
	 * 城市信息
	 */
	private String city;

	/**
	 * 语言信息
	 */
	private String language;

	/**
	 * 用户标签的id，可通过用户标签管理接口获取。创建规则时使用此字段。
	 * 
	 * @return the tagId
	 */
	public String getTagId() {
		return tagId;
	}

	/**
	 * 用户标签的id，可通过用户标签管理接口获取。创建规则时使用此字段。
	 * 
	 * @param tagId
	 *            the tagId to set
	 */
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	/**
	 * 性别：男（1）女（2），不填则不做匹配
	 * 
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 性别：男（1）女（2），不填则不做匹配
	 * 
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
	 * 
	 * @return the clientPlatformType
	 */
	public Integer getClientPlatformType() {
		return clientPlatformType;
	}

	/**
	 * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
	 * 
	 * @param clientPlatformType
	 *            the clientPlatformType to set
	 */
	public void setClientPlatformType(Integer clientPlatformType) {
		this.clientPlatformType = clientPlatformType;
	}

	/**
	 * 国家信息，是用户在微信中设置的地区
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 国家信息，是用户在微信中设置的地区
	 * 
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 省份信息
	 * 
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 省份信息
	 * 
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 城市信息
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 城市信息
	 * 
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 语言信息
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * 语言信息
	 * 
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * 用户组的ID。含义应该是与tagId一致，目前的文档中在菜单查询时返回时是叫groupId。
	 * 
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * 用户组的ID。含义应该是与tagId一致，目前的文档中在菜单查询时返回时是叫groupId。
	 * 
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
