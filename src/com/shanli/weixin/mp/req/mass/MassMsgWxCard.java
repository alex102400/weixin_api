package com.shanli.weixin.mp.req.mass;

import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.bean.WxCard;

/**
 * 卡券
 * 
 * @author alex
 *
 */
public class MassMsgWxCard extends MassMsg {
	private WxCard wxcard = new WxCard();

	public MassMsgWxCard(String cardId) {
		this.setMsgtype(MediaTypeEnum.wxcard);
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
