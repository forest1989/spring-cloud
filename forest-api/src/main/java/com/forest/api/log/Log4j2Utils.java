package com.forest.api.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author forest
 *
 */
public class Log4j2Utils {
	
	/**
	  * 获取业务日志logger
	 *
	 * @return
	 */
	public static Logger getBussinessLogger() {
		return LoggerFactory.getLogger(Log4j2Enum.BUSSINESS.getCategory());
	}

	/**
	 * 获取平台日志logger
	 *
	 * @return
	 */
	public static Logger getPlatformLogger() {
		return LoggerFactory.getLogger(Log4j2Enum.PLATFORM.getCategory());
	}

	/**
	 * 获取数据库日志logger
	 *
	 * @return
	 */
	public static Logger getDBLogger() {
		return LoggerFactory.getLogger(Log4j2Enum.DB.getCategory());
	}

	/**
	 * 获取异常日志logger
	 *
	 * @return
	 */
	public static Logger getExceptionLogger() {
		return LoggerFactory.getLogger(Log4j2Enum.EXCEPTION.getCategory());
	}

}
