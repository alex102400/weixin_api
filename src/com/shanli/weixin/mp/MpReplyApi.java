package com.shanli.weixin.mp;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.recv.UserMsg;
import com.shanli.weixin.mp.recv.UserMsgText;
import com.shanli.weixin.mp.recv.event.MsgEvent;
import com.shanli.weixin.mp.req.custom.CustomMsgText;
import com.shanli.weixin.mp.req.reply.BaseReply;
import com.shanli.weixin.mp.req.reply.ReplyText;
import com.shanli.weixin.mp.req.reply.ReplyTransfer;
import com.shanli.weixin.mp.resp.msg.GetCurrentAutoReplyInfoResp;
import com.shanli.weixin.open.OpenApi;
import com.shanli.weixin.util.HttpUtil;
import com.shanli.weixin.util.XmlUtil;
import com.shanli.weixin.util.aes.WXBizMsgCrypt;

/**
 * 被动回复消息API。
 * 
 * @author alex
 *
 */
public class MpReplyApi {
	private MpApi mpApi;

	public MpReplyApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 获取公众号的自动回复规则
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public GetCurrentAutoReplyInfoResp apiGetCurrentAutoReplyInfo()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();

		String path = String.format("/get_current_autoreply_info?access_token=%s", token.getAccessToken());
		// 构建请求参数进行获取
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetCurrentAutoReplyInfoResp resp = new Gson().fromJson(respText, GetCurrentAutoReplyInfoResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiGetCurrentAutoReplyInfo %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 生成被动回复消息（已加密）。
	 * 
	 * @param reply
	 * @return
	 */
	public String buildReply(BaseReply reply) {
		try {
			String replyMsg = XmlUtil.toXml(reply);
			WXBizMsgCrypt wxc = null;
			if (mpApi.config.isOpenMode()) {// 开放平台模式
				wxc = new WXBizMsgCrypt(OpenApi.getInstance().getConfig().getComponentToken(),
						OpenApi.getInstance().getConfig().getComponentEncodingAesKey(),
						OpenApi.getInstance().getConfig().getComponentAppid());
			} else {// 公众平台
				wxc = new WXBizMsgCrypt(mpApi.config.getAppToken(), mpApi.config.getAppEncodingAESKey(),
						mpApi.config.getAppId());
			}
			return wxc.encryptMsg(replyMsg, Long.toString(System.currentTimeMillis()), mpApi.config.getEncryptNonce());
		} catch (Exception e) {
			mpApi.log.error("生成被动回复消息异常", e);
		}

		return null;
	}

	/**
	 * 创建转发客服的被动回复消息。
	 * 
	 * @param usermsg
	 * @param kfAccount
	 * @return
	 */
	public String buildTrans(UserMsg usermsg, String kfAccount) {
		return buildReply(new ReplyTransfer(usermsg, kfAccount));
	}

	/**
	 * 创建全网发布检测回复消息
	 * 
	 * @param usermsg
	 * @return
	 */
	public String buildPublishDetect(UserMsg usermsg) {
		if (usermsg instanceof MsgEvent) {// 接收模拟粉丝事件消息，回复特定内容文本消息
			MsgEvent evt = (MsgEvent) usermsg;
			ReplyText replyText = new ReplyText(usermsg, evt.getEvent() + "from_callback");
			return buildReply(replyText);
		}
		// 文本消息
		if (usermsg instanceof UserMsgText) {
			UserMsgText userMsgText = (UserMsgText) usermsg;
			String content = userMsgText.getContent();
			// 接收模拟粉丝发送的文本消息，回复特定内容文本消息
			if ("TESTCOMPONENT_MSG_TYPE_TEXT".equals(content)) {
				ReplyText replyText = new ReplyText(usermsg, "TESTCOMPONENT_MSG_TYPE_TEXT_callback");
				return buildReply(replyText);
			}
			// 接收模拟粉丝发送的文本消息，通过客服接口回复特定内容文本消息
			String key = "QUERY_AUTH_CODE:";
			if (StringUtils.startsWith(content, key)) {
				final String authcode = StringUtils.substringAfter(content, key);
				final String from = userMsgText.getFromUserName();
				OpenApi.getInstance().getWorker().execute(new Runnable() {
					@Override
					public void run() {
						try {
							OpenApi.getInstance().apiQueryAuth(authcode);
							CustomMsgText cmsg = new CustomMsgText(from, authcode + "_from_api");
							mpApi.getMsgApi().apiMessageCustomSend(cmsg);
						} catch (Exception e) {
							mpApi.log.error("进行全网发布检测时回复客服消息失败", e);
						}

					}
				});

				return "";
			}
		}
		return "";
	}

}
