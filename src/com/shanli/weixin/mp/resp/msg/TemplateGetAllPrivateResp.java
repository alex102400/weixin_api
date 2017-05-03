package com.shanli.weixin.mp.resp.msg;

import com.google.gson.annotations.SerializedName;
import com.shanli.weixin.bean.BaseResp;

/**
 * 获取已添加至帐号下所有模板列表
 * 
 * @author alex
 *
 */
public class TemplateGetAllPrivateResp extends BaseResp {
	@SerializedName("template_list")
	private Template[] templateList;

	public static class Template {
		@SerializedName("template_id")
		private String template_id;// 模板ID
		private String title;// 模板标题
		@SerializedName("primary_industry")
		private String primaryIndustry;// 模板所属行业的一级行业
		@SerializedName("deputy_industry")
		private String deputyIndustry;// 模板所属行业的二级行业
		private String content;// 模板内容
		private String example;// 模板示例

		/**
		 * 模板ID
		 * 
		 * @return the template_id
		 */
		public String getTemplate_id() {
			return template_id;
		}

		/**
		 * 模板ID
		 * 
		 * @param template_id
		 *            the template_id to set
		 */
		public void setTemplate_id(String template_id) {
			this.template_id = template_id;
		}

		/**
		 * 模板标题
		 * 
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * 模板标题
		 * 
		 * @param title
		 *            the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * 模板所属行业的一级行业
		 * 
		 * @return the primaryIndustry
		 */
		public String getPrimaryIndustry() {
			return primaryIndustry;
		}

		/**
		 * 模板所属行业的一级行业
		 * 
		 * @param primaryIndustry
		 *            the primaryIndustry to set
		 */
		public void setPrimaryIndustry(String primaryIndustry) {
			this.primaryIndustry = primaryIndustry;
		}

		/**
		 * 模板所属行业的二级行业
		 * 
		 * @return the deputyIndustry
		 */
		public String getDeputyIndustry() {
			return deputyIndustry;
		}

		/**
		 * 模板所属行业的二级行业
		 * 
		 * @param deputyIndustry
		 *            the deputyIndustry to set
		 */
		public void setDeputyIndustry(String deputyIndustry) {
			this.deputyIndustry = deputyIndustry;
		}

		/**
		 * 模板内容
		 * 
		 * @return the content
		 */
		public String getContent() {
			return content;
		}

		/**
		 * 模板内容
		 * 
		 * @param content
		 *            the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}

		/**
		 * 模板示例
		 * 
		 * @return the example
		 */
		public String getExample() {
			return example;
		}

		/**
		 * 模板示例
		 * 
		 * @param example
		 *            the example to set
		 */
		public void setExample(String example) {
			this.example = example;
		}

	}
}
