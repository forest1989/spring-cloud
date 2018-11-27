package com.forest.api.common.config;

import java.util.Map;

import com.forest.api.common.PropertiesLoader;
import com.forest.api.common.utils.StringUtils;
import com.google.common.collect.Maps;


/**
   *   全局配置类 懒汉式单例类.在第一次调用的时候实例化自己
 * @author forest
 * @version 2018年1月5日
 */
public class Global {

	private Global() {}

	/**
	 * 当前对象实例
	 */
	private static Global global = null;

	/**
	 * 静态工厂方法 获取当前对象实例 多线程安全单例模式(使用双重同步锁)
	 */

	public static synchronized Global getInstance() {

		if (global == null) {
			synchronized (Global.class) {
				if (global == null)
					global = new Global();
			}
		}
		return global;
	}

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("forest.properties");

	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";

	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";

	

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 页面获取常量
	 * 
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}
}
