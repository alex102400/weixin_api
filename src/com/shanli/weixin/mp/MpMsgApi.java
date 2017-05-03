package com.shanli.weixin.mp;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.req.custom.CustomMsg;
import com.shanli.weixin.mp.req.mass.MassMsg;
import com.shanli.weixin.mp.resp.msg.MessageMassGetResp;
import com.shanli.weixin.mp.resp.msg.MessageMassSendAllResp;
import com.shanli.weixin.mp.resp.msg.MessageTemplateSendResp;
import com.shanli.weixin.mp.resp.msg.TemplateApiAddResp;
import com.shanli.weixin.mp.resp.msg.TemplateGetAllPrivateResp;
import com.shanli.weixin.mp.resp.msg.TemplateGetIndustryResp;
import com.shanli.weixin.util.HttpUtil;

/**
 * 公众号消息管理API
 * 
 * @author alex
 *
 */
public class MpMsgApi {
	private MpApi mpApi;

	public MpMsgApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 发送客服消息
	 * 
	 * @param msg
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMessageCustomSend(CustomMsg msg)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/message/custom/send?access_token=%s", token.getAccessToken());
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, msg);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMessageCustomSend %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 群发消息。
	 * 
	 * @param msg
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MessageMassSendAllResp apiMessageMassSendAll(MassMsg msg)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/message/mass/sendall?access_token=%s", token.getAccessToken());

		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, msg);
		MessageMassSendAllResp resp = new Gson().fromJson(respText, MessageMassSendAllResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMessageMassSendAll %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 删除群发消息。 1、只有已经发送成功的消息才能删除 2、删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
	 * 3、删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
	 * 4、如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息也，导致所有群发都失效
	 * 
	 * @param massMsgId
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMessageMassDelete(String massMsgId)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/message/mass/delete?access_token=%s", token.getAccessToken());

		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("msg_id", massMsgId);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMessageMassDelete %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 群发消息预览
	 * 
	 * @param towxname
	 * @param msg
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMessageMassPreview(String towxname, MassMsg msg)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClientProtocolException,
			URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/message/mass/preview?access_token=%s", token.getAccessToken());

		Map<String, Object> reqMap = PropertyUtils.describe(msg);
		reqMap.put("towxname", towxname);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMessageMassDelete %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 查询群发消息发送状态【订阅号与服务号认证后均可用】
	 * 
	 * @param massMsgId
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMessageMassGet(String massMsgId)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/message/mass/get?access_token=%s", token.getAccessToken());

		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("msg_id", massMsgId);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		MessageMassGetResp resp = new Gson().fromJson(respText, MessageMassGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMessageMassGet %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 发送模板消息。 在模版消息发送任务完成后，有事件TEMPLATESENDJOBFINISH通知。
	 * 
	 * @param touser
	 * @param templateId
	 * @param url
	 * @param data
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MessageTemplateSendResp apiMessageTemplateSend(String touser, String templateId, String url, String data)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/message/template/send?access_token=%s", token.getAccessToken());
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("touser", touser);
		reqMap.put("template_id", templateId);
		reqMap.put("url", url);
		reqMap.put("data", data);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);

		MessageTemplateSendResp resp = new Gson().fromJson(respText, MessageTemplateSendResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMessageTemplateSend %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取设置的行业信息
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public TemplateGetIndustryResp apiTemplateGetIndustry()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/template/get_industry?access_token=%s", token.getAccessToken());

		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		TemplateGetIndustryResp resp = new Gson().fromJson(respText, TemplateGetIndustryResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTemplateGetIndustry %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 设置所属行业。每月可修改行业1次，账号仅可使用所属行业中相关的模板
	 * 
	 * @param industryId1
	 * @param industryId2
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTemplateApiSetIndustry(String industryId1, String industryId2)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/template/api_set_industry?access_token=%s", token.getAccessToken());

		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("industry_id1", industryId1);
		reqMap.put("industryId2", industryId2);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTemplateApiSetIndustry %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 从模板库中选择模板添加到公众号下。建议引导用户至MP管理平台进行操作。
	 * 
	 * @param templateIdShort
	 *            模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public TemplateApiAddResp apiTemplateApiAddTemplate(String templateIdShort)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/template/api_add_template?access_token=%s", token.getAccessToken());

		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("template_id_short", templateIdShort);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		TemplateApiAddResp resp = new Gson().fromJson(respText, TemplateApiAddResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTemplateApiAddTemplate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取已添加至帐号下所有模板列表
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public TemplateGetAllPrivateResp apiTemplateGetAllPrivateTemplate()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/template/get_all_private_template?access_token=%s", token.getAccessToken());

		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		TemplateGetAllPrivateResp resp = new Gson().fromJson(respText, TemplateGetAllPrivateResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTemplateGetAllPrivateTemplate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 删除模板
	 * 
	 * @param templateId
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiTemplateDelPrivateTemplate(String templateId)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/template/del_private_template?access_token=%s", token.getAccessToken());

		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("template_id", templateId);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);

		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiTemplateDelPrivateTemplate %s", new Gson().toJson(resp)));
		}
		return resp;
	}

}
