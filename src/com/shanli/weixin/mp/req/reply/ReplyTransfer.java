package com.shanli.weixin.mp.req.reply;

import org.apache.commons.lang3.StringUtils;

import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.recv.UserMsg;

/**
 * 转发给客服。
 * 
 * @author alex
 *
 */
public class ReplyTransfer extends BaseReply {
	private TransInfo transInfo;

	/**
	 * 转发给随机客服
	 */
	public ReplyTransfer(UserMsg userMsg) {
		super(userMsg, MediaTypeEnum.transfer_customer_service);
	}

	/**
	 * 转发给指定客服
	 * 
	 * @param kfAccount
	 */
	public ReplyTransfer(UserMsg userMsg, String kfAccount) {
		super(userMsg, MediaTypeEnum.transfer_customer_service);
		if (!StringUtils.isEmpty(kfAccount)) {
			transInfo = new TransInfo();
			transInfo.kfAccount = kfAccount;
		}
	}

	public static class TransInfo {
		private String kfAccount;

		/**
		 * @return the kfAccount
		 */
		public String getKfAccount() {
			return kfAccount;
		}

		/**
		 * @param kfAccount
		 *            the kfAccount to set
		 */
		public void setKfAccount(String kfAccount) {
			this.kfAccount = kfAccount;
		}

	}

	/**
	 * @return the transInfo
	 */
	public TransInfo getTransInfo() {
		return transInfo;
	}

	/**
	 * @param transInfo
	 *            the transInfo to set
	 */
	public void setTransInfo(TransInfo transInfo) {
		this.transInfo = transInfo;
	}
}
