package com.base.framwork.service;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.base.framwork.util.DateUtil;

/**
 * 工具Service
 * @author chenas
 *
 */
@Component
public class UtilService implements IUtilService{

	/**
	 * 取得系统当前时间
	 * 
	 * @return 系统当前时间
	 */
	public Date getSystemDateTime() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * 取得系统当前日期组成的字符串 默认格式为：yyyy-MM-dd
	 * 
	 * @return 系统当前日期组成的字符串
	 */
	public String getSystemDateString() {
		return DateUtil.getDateTime("yyyy-MM-dd", getSystemDateTime());
	}

	/**
	 * 取得系统当前日期＋时间组成的字符串 默认格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return 系统当前日期＋时间组成的字符串
	 */
	public String getSystemDateTimeString() {
		return DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", getSystemDateTime());
	}
	
	/**
	 * 获得字符串的md5编码
	 * @param resString
	 * @return
	 *  	md5字符串
	 */
	public String getMD5String(String resString){
		// MD5加码。32位,不可逆,用于加密密码
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
				return "";
			}
			char[] charArray = resString.toCharArray();
			byte[] byteArray = new byte[charArray.length];
			for (int i = 0; i < charArray.length; i++)
				byteArray[i] = (byte) charArray[i];
			byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
	}
	
/*	public static void main(String[] args){
		UtilService us = new UtilService();
		String str = us.getMD5String("1234");
		System.out.println(str);
	}*/
	
}
