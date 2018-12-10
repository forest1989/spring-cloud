/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.forest.common.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
   *   封装各种生成唯一性ID算法的工具类.
 * @author forest
 * 
 */
public class IdGen {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}


//	public static void main(String[] args) {
//		System.out.println(IdGen.uuid());
//		System.out.println(IdGen.uuid().length());
//	}

}
