package com.forest.api.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.api.common.utils.CommonResult;

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
	public CommonResult allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
        return new CommonResult(500, exception.getMessage());  
	}
}
