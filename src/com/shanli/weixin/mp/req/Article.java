package com.shanli.weixin.mp.req;

import com.google.gson.annotations.SerializedName;

/**
 * 图文消息素材
 * 
 * @author alex
 *
 */
public class Article {
	@SerializedName("thumb_media_id")
	private String thumbMediaId;// 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得

	private String author;// 图文消息的作者
	private String title;// 图文消息的标题
	@SerializedName("content_source_url")
	private String contentSourceUrl;// 在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加
									// #wechat_redirect 后缀。
	private String content;// 图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用
	private String digest;// 图文消息的描述
	@SerializedName("show_cover_pic")
	private Integer showCoverPic;// 是否显示封面，1为显示，0为不显示

	public Article() {
		super();
	}

	public Article(String thumbMediaId, String author, String title, String contentSourceUrl, String content,
			String digest, Integer showCoverPic) {
		super();
		this.thumbMediaId = thumbMediaId;
		this.author = author;
		this.title = title;
		this.contentSourceUrl = contentSourceUrl;
		this.content = content;
		this.digest = digest;
		this.showCoverPic = showCoverPic;
	}

	/**
	 * @return the thumbMediaId
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	/**
	 * @param thumbMediaId
	 *            the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the contentSourceUrl
	 */
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}

	/**
	 * @param contentSourceUrl
	 *            the contentSourceUrl to set
	 */
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 图文消息的描述
	 * 
	 * @return the digest
	 */
	public String getDigest() {
		return digest;
	}

	/**
	 * 图文消息的描述
	 * 
	 * @param digest
	 *            the digest to set
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}

	/**
	 * @return the showCoverPic
	 */
	public Integer getShowCoverPic() {
		return showCoverPic;
	}

	/**
	 * @param showCoverPic
	 *            the showCoverPic to set
	 */
	public void setShowCoverPic(Integer showCoverPic) {
		this.showCoverPic = showCoverPic;
	}

}
