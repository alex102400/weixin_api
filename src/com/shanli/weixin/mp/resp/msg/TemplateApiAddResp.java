package com.shanli.weixin.mp.resp.msg;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 从模板库添加模板到公众号
 * 
 * @author alex
 *
 */
public class TemplateApiAddResp extends BaseResp {
	@SerializedName("template_id")
	private String templateId;

	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId
	 *            the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
