package com.shanli.weixin.mp.req.custom;

import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.bean.WxCard;

/**
 * 卡券
 * 
 * @author alex
 *
 */
public class CustomMsgWxCard extends CustomMsg {
	private WxCard wxcard = new WxCard();

	public CustomMsgWxCard(String touser, String cardId) {
		super(touser, MediaTypeEnum.wxcard);
		wxcard.setCardId(cardId);
	}

	/**
	 * @return the wxcard
	 */
	public WxCard getWxcard() {
		return wxcard;
	}

	/**
	 * @param wxcard
	 *            the wxcard to set
	 */
	public void setWxcard(WxCard wxcard) {
		this.wxcard = wxcard;
	}
}
