package com.base.framwork.service;

import java.util.Date;

public interface IUtilService {
	/**
	 * 取得系统当前时间
	 * 
	 * @return 系统当前时间
	 */
	public Date getSystemDateTime();

	/**
	 * 取得系统当前日期组成的字符串
	 * 
	 * @return 系统当前日期组成的字符串
	 */
	public String getSystemDateString();

	/**
	 * 取得系统当前日期＋时间组成的字符串
	 * 
	 * @return 系统当前日期＋时间组成的字符串
	 */
	public String getSystemDateTimeString();

}
