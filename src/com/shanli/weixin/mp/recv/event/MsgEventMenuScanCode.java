package com.shanli.weixin.mp.recv.event;

import com.google.gson.Gson;

/**
 * 菜单扫码事件
 * 
 * @author alex
 *
 */
public class MsgEventMenuScanCode extends MsgEventMenuClick {
	private ScanCodeInfo scanCodeInfo;// 扫描信息

	/**
	 * 扫描信息
	 * 
	 * @author alex
	 *
	 */
	public static class ScanCodeInfo {
		private String scanType;// 扫描类型，一般是qrcode
		private String scanResult;// 扫描结果，即二维码对应的字符串信息

		/**
		 * 扫描类型，一般是qrcode
		 * 
		 * @return the scanType
		 */
		public String getScanType() {
			return scanType;
		}

		/**
		 * 扫描类型，一般是qrcode
		 * 
		 * @param scanType
		 *            the scanType to set
		 */
		public void setScanType(String scanType) {
			this.scanType = scanType;
		}

		/**
		 * 扫描结果，即二维码对应的字符串信息
		 * 
		 * @return the scanResult
		 */
		public String getScanResult() {
			return scanResult;
		}

		/**
		 * 扫描结果，即二维码对应的字符串信息
		 * 
		 * @param scanResult
		 *            the scanResult to set
		 */
		public void setScanResult(String scanResult) {
			this.scanResult = scanResult;
		}

		/*
		 * JSON字符串
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return new Gson().toJson(this);
		}

	}

	/**
	 * 扫描信息
	 * 
	 * @return the scanCodeInfo
	 */
	public ScanCodeInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	/**
	 * 扫描信息
	 * 
	 * @param scanCodeInfo
	 *            the scanCodeInfo to set
	 */
	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

}
