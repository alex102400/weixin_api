package com.shanli.weixin.mp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 微信卡券
 * 
 * @author alex
 *
 */
public class WxCard {
	@SerializedName("card_id")
	private String cardId;

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId
	 *            the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
