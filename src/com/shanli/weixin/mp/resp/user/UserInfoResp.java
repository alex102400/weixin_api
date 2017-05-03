package com.shanli.weixin.mp.resp.user;

import com.google.gson.annotations.SerializedName;

/**
 * 微信用户信息
 * 
 * @author alex
 *
 */
public class UserInfoResp {

	private Integer subscribe;// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private String openid;
	private String nickname;
	private Integer sex;
	private String language;
	private String city;
	private String province;
	private String country;
	private String headimgurl;
	@SerializedName("subscribe_time")
	private Long subscribeTime;
	private String unionid;
	private String remark;
	private String groupid;
	@SerializedName("tagid_list")
	private Integer[] tagidList;

	private String[] privilege;

	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 * 
	 * @return the subscribe
	 */
	public Integer getSubscribe() {
		return subscribe;
	}

	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 * 
	 * @param subscribe
	 *            the subscribe to set
	 */
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	/**
	 * 用户的标识，对当前公众号唯一
	 * 
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 用户的标识，对当前公众号唯一
	 * 
	 * @param openid
	 *            the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 用户的昵称
	 * 
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 用户的昵称
	 * 
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 * 
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 * 
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 用户的语言，简体中文为zh_CN
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * 用户的语言，简体中文为zh_CN
	 * 
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * 用户所在城市
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 用户所在城市
	 * 
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 用户所在国家
	 * 
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 用户所在国家
	 * 
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 用户所在省份
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 用户所在省份
	 * 
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 * 
	 * @return the headimgurl
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 * 
	 * @param headimgurl
	 *            the headimgurl to set
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 * 
	 * @return the subscribeTime
	 */
	public Long getSubscribeTime() {
		return subscribeTime;
	}

	/**
	 * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 * 
	 * @param subscribeTime
	 *            the subscribeTime to set
	 */
	public void setSubscribeTime(Long subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 * 
	 * @return the unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 * 
	 * @param unionid
	 *            the unionid to set
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	 * 
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	 * 
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 用户所在的分组ID（兼容旧的用户分组接口）
	 * 
	 * @return the groupid
	 */
	public String getGroupid() {
		return groupid;
	}

	/**
	 * 用户所在的分组ID（兼容旧的用户分组接口）
	 * 
	 * @param groupid
	 *            the groupid to set
	 */
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	/**
	 * 用户被打上的标签ID列表
	 * 
	 * @return the tagidList
	 */
	public Integer[] getTagidList() {
		return tagidList;
	}

	/**
	 * 用户被打上的标签ID列表
	 * 
	 * @param tagidList
	 *            the tagidList to set
	 */
	public void setTagidList(Integer[] tagidList) {
		this.tagidList = tagidList;
	}

	/**
	 * 用户特权信息，如微信沃卡用户为（chinaunicom）
	 * 
	 * @return the privilege
	 */
	public String[] getPrivilege() {
		return privilege;
	}

	/**
	 * 用户特权信息，如微信沃卡用户为（chinaunicom）
	 * 
	 * @param privilege
	 *            the privilege to set
	 */
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}

}
