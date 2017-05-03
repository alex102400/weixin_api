package com.shanli.weixin.open.resp;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 公众号帐号基本信息。可以随时获取，无有效期也不需要缓存。
 * 
 * @author alex
 *
 */
public class GetAuthorizerInfo extends BaseResp{

	@SerializedName("authorizer_info")
	private AuthorizerInfo authorizerInfo;

	@SerializedName("authorization_info")
	private AuthorizationInfo authorizationInfo;

	/**
	 * 授权者信息
	 * 
	 * @return the authorizerInfo
	 */
	public AuthorizerInfo getAuthorizerInfo() {
		return authorizerInfo;
	}

	/**
	 * 授权者信息
	 * 
	 * @param authorizerInfo
	 *            the authorizerInfo to set
	 */
	public void setAuthorizerInfo(AuthorizerInfo authorizerInfo) {
		this.authorizerInfo = authorizerInfo;
	}

	/**
	 * 权限信息
	 * 
	 * @return the authorizationInfo
	 */
	public AuthorizationInfo getAuthorizationInfo() {
		return authorizationInfo;
	}

	/**
	 * 权限信息
	 * 
	 * @param authorizationInfo
	 *            the authorizationInfo to set
	 */
	public void setAuthorizationInfo(AuthorizationInfo authorizationInfo) {
		this.authorizationInfo = authorizationInfo;
	}

	/**
	 * 公众号信息
	 * 
	 * @author alex
	 *
	 */
	public class AuthorizerInfo {
		@SerializedName("nick_name")
		private String nickName;

		@SerializedName("head_img")
		private String headImg;

		@SerializedName("service_type_info")
		private IDValue serviceTypeInfo;

		@SerializedName("verify_type_info")
		private IDValue verifyTypeInfo;

		@SerializedName("user_name")
		private String userName;

		@SerializedName("principal_name")
		private String principalName;

		@SerializedName("business_info")
		private BusinessInfo businessInfo;

		private String alias;

		@SerializedName("qrcode_url")
		private String qrcodeUrl;

		/**
		 * 授权方昵称
		 * 
		 * @return
		 */
		public String getNickName() {
			return nickName;
		}

		/**
		 * 授权方昵称
		 * 
		 * @param nickName
		 */
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

		/**
		 * 授权方头像URL
		 * 
		 * @return
		 */
		public String getHeadImg() {
			return headImg;
		}

		/**
		 * 授权方头像URL
		 * 
		 * @param headImg
		 */
		public void setHeadImg(String headImg) {
			this.headImg = headImg;
		}

		/**
		 * 授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
		 * 
		 * @return
		 */
		public IDValue getServiceTypeInfo() {
			return serviceTypeInfo;
		}

		/**
		 * 授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
		 * 
		 * @param serviceTypeInfo
		 */
		public void setServiceTypeInfo(IDValue serviceTypeInfo) {
			this.serviceTypeInfo = serviceTypeInfo;
		}

		/**
		 * 授权方认证类型。 -1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，
		 * 3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
		 * 5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
		 * 
		 * @return
		 */
		public IDValue getVerifyTypeInfo() {
			return verifyTypeInfo;
		}

		/**
		 * 授权方认证类型。 -1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，
		 * 3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，
		 * 5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
		 * 
		 * @param verifyTypeInfo
		 */
		public void setVerifyTypeInfo(IDValue verifyTypeInfo) {
			this.verifyTypeInfo = verifyTypeInfo;
		}

		/**
		 * 授权方公众号的原始ID
		 * 
		 * @return
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * 授权方公众号的原始ID
		 * 
		 * @param userName
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}

		/**
		 * 公众号的主体名称
		 * 
		 * @return
		 */
		public String getPrincipalName() {
			return principalName;
		}

		/**
		 * 公众号的主体名称
		 * 
		 * @param principalName
		 */
		public void setPrincipalName(String principalName) {
			this.principalName = principalName;
		}

		/**
		 * 业务开通情况。
		 * 
		 * @return
		 */
		public BusinessInfo getBusinessInfo() {
			return businessInfo;
		}

		/**
		 * 业务开通情况。
		 * 
		 * @param businessInfo
		 */
		public void setBusinessInfo(BusinessInfo businessInfo) {
			this.businessInfo = businessInfo;
		}

		/**
		 * 授权方公众号所设置的微信号，可能为空
		 * 
		 * @return
		 */
		public String getAlias() {
			return alias;
		}

		/**
		 * 授权方公众号所设置的微信号，可能为空
		 * 
		 * @param alias
		 */
		public void setAlias(String alias) {
			this.alias = alias;
		}

		/**
		 * 二维码图片的URL，开发者最好自行也进行保存
		 * 
		 * @return
		 */
		public String getQrcodeUrl() {
			return qrcodeUrl;
		}

		/**
		 * 二维码图片的URL，开发者最好自行也进行保存
		 * 
		 * @param qrcodeUrl
		 */
		public void setQrcodeUrl(String qrcodeUrl) {
			this.qrcodeUrl = qrcodeUrl;
		}

	}

	/**
	 * 业务开通情况。 用以了解微信扫码、支付、卡券等功能的开通状况（0代表未开通，1代表已开通）。
	 * 
	 * @author alex
	 *
	 */
	public class BusinessInfo {

		@SerializedName("open_store")
		private Integer openStore;

		@SerializedName("open_scan")
		private Integer openScan;

		@SerializedName("open_pay")
		private Integer openPay;

		@SerializedName("open_card")
		private Integer openCard;

		@SerializedName("open_shake")
		private Integer openShake;

		/**
		 * 是否开通微信门店功能
		 * 
		 * @return
		 */
		public Integer getOpenStore() {
			return openStore;
		}

		/**
		 * 是否开通微信门店功能
		 * 
		 * @param openStore
		 */
		public void setOpenStore(Integer openStore) {
			this.openStore = openStore;
		}

		/**
		 * 是否开通微信扫商品功能
		 * 
		 * @return
		 */
		public Integer getOpenScan() {
			return openScan;
		}

		/**
		 * 是否开通微信扫商品功能
		 * 
		 * @param openScan
		 */
		public void setOpenScan(Integer openScan) {
			this.openScan = openScan;
		}

		/**
		 * 是否开通微信支付功能
		 * 
		 * @return
		 */
		public Integer getOpenPay() {
			return openPay;
		}

		/**
		 * 是否开通微信支付功能
		 * 
		 * @param openPay
		 */
		public void setOpenPay(Integer openPay) {
			this.openPay = openPay;
		}

		/**
		 * 是否开通微信卡券功能
		 * 
		 * @return
		 */
		public Integer getOpenCard() {
			return openCard;
		}

		/**
		 * 是否开通微信卡券功能
		 * 
		 * @param openCard
		 */
		public void setOpenCard(Integer openCard) {
			this.openCard = openCard;
		}

		/**
		 * 是否开通微信摇一摇功能
		 * 
		 * @return
		 */
		public Integer getOpenShake() {
			return openShake;
		}

		/**
		 * 是否开通微信摇一摇功能
		 * 
		 * @param openShake
		 */
		public void setOpenShake(Integer openShake) {
			this.openShake = openShake;
		}

	}

	/**
	 * 授权信息
	 * 
	 * @author alex
	 *
	 */
	public class AuthorizationInfo {
		/**
		 * 授权方appid
		 */
		private String appid;

		/**
		 * 公众号授权给开发者的权限集列表
		 */
		@SerializedName("func_info")
		private FuncInfo[] funcInfo;

		/**
		 * 授权方appid
		 * 
		 * @return
		 */
		public String getAppid() {
			return appid;
		}

		/**
		 * 授权方appid
		 * 
		 * @param appid
		 */
		public void setAppid(String appid) {
			this.appid = appid;
		}

		/**
		 * 公众号授权给开发者的权限集列表
		 * 
		 * @return
		 */
		public FuncInfo[] getFuncInfo() {
			return funcInfo;
		}

		/**
		 * 公众号授权给开发者的权限集列表
		 * 
		 * @param funcInfo
		 */
		public void setFuncInfo(FuncInfo[] funcInfo) {
			this.funcInfo = funcInfo;
		}

	}

	/**
	 * 权限集，ID为1到15时分别代表： 消息管理权限 用户管理权限 帐号服务权限 网页服务权限 微信小店权限 微信多客服权限 群发与通知权限
	 * 微信卡券权限 微信扫一扫权限 微信连WIFI权限 素材管理权限 微信摇周边权限 微信门店权限 微信支付权限 自定义菜单权限
	 * 
	 * @author alex
	 *
	 */
	public class FuncInfo {
		@SerializedName("funcscope_category")
		private IDValue funcscopeCategory;

		public IDValue getFuncscopeCategory() {
			return funcscopeCategory;
		}

		public void setFuncscopeCategory(IDValue funcscopeCategory) {
			this.funcscopeCategory = funcscopeCategory;
		}

	}

	/**
	 * ID值。用于FuncInfo等处。
	 * 
	 * @author alex
	 *
	 */
	public class IDValue {
		private Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	}

}
