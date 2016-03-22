package com.mrcode.utils;

import java.security.MessageDigest;

public class DigestUtil {
	/**
	 * *****************************************************
	 * 
	 * @function：将密码用MD5加密(有加盐处理)
	 * @param：sPassword 待加密的密码字符串
	 * @return: String MD5字符串
	 * *****************************************************
	 */
	public static String encryptPWD(String sPassword) {
		byte cResult[] = new byte[16];
		String sResult = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(("www.MD5.com.cn" + sPassword).getBytes());
			cResult = md.digest();

			for (int i = 0; i < cResult.length; i++) {
				if (cResult[i] < 0) {
					cResult[i] += 128;
				}
				String sTemp = Integer.toHexString(cResult[i]).toUpperCase();
				if (cResult[i] < 16) {
					sTemp = "0" + sTemp;
				}
				sResult += sTemp;
			}
		} catch (Exception e) {
			sResult = "";
		}
		return sResult;
	}
	
	
	public static void main(String[] args) {
		System.out.println(DigestUtil.encryptPWD("admin"));
	}
}

