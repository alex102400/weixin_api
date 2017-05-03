/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package com.shanli.weixin.util.aes;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map.Entry;

/**
 * SHA1 class
 *
 * 计算公众平台的消息签名接口.
 */
public class SHA1 {

	/**
	 * 用SHA1算法生成安全签名
	 * 
	 * @return 安全签名
	 * @throws AesException
	 */
	public static String getSHA1(String... args) throws AesException {
		try {
			StringBuffer sb = new StringBuffer(2048);
			// 字符串排序
			Arrays.sort(args);
			for (int i = 0; i < args.length; i++) {
				sb.append(args[i]);
			}
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer(64);
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}

	/**
	 * 用SHA1算法生成URL参数安全签名
	 * 
	 * @param params
	 *            参数表key,value
	 * @return 安全签名
	 * @throws AesException
	 */
	public static String getSHA1(Hashtable<String, Object> params) throws AesException {
		try {
			int size = params.size();
			String[] array = new String[size];
			int pos = 0;
			for (Entry<String, Object> param : params.entrySet()) {
				array[pos] = String.format("%s=%s", param.getKey(), param.getValue());
				pos++;
			}
			StringBuffer sb = new StringBuffer(2048);
			// 字符串排序
			Arrays.sort(array);
			for (int i = 0; i < array.length; i++) {
				if (i != 0) {
					sb.append("&");
				}
				sb.append(array[i]);
			}
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer(64);
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}
}
