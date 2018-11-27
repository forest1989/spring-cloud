package com.forest.api.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author forest
 *
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 所有异常报错
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public String allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {

		exception.printStackTrace();
		JSONObject obj = new JSONObject();
		obj.put("status", "1");
		obj.put("msg", exception.getMessage());
		obj.put("data", "");
        return obj.toJSONString();  
	}
}
