package com.forest.api.webapi.sys.utils;

import com.forest.api.entity.User;


/**
 * 用户工具类
 * @author forest
 * @version 2018-12-05
 */
public class UserUtils {

	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id){
		User user = new User();
		// 根据实际业务编码
		
		return user;
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		// 根据实际业务编码
		
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByLoginName(String loginName){
		User user = new User();
		// 根据实际业务编码
		
		return user;
	}
	
}
