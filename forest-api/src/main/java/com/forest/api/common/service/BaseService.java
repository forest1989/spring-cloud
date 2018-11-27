package com.forest.api.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service基类
 * @author forest
 * @version 2018-05-16
 */
@Transactional(readOnly = true)
public abstract class BaseService {
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	
}
