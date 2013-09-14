package com.base.framwork.service;

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
}
