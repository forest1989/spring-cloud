package com.forest.api.webapi;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.forest.api.common.log.Log4j2Utils;
import com.forest.api.common.utils.CommonResult;
import com.forest.api.common.web.BaseController;
import com.forest.api.entity.Demo;
import com.forest.api.service.DemoService;

/**
 * 
 * @author forest
 *
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController extends BaseController{

	@Value("${server.port}")
    String port;

	@Autowired
	private DemoService demoService;
	
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public CommonResult hello() throws InterruptedException {
    	
    	Logger log = Log4j2Utils.getExceptionLogger();
    	Logger log1 = Log4j2Utils.getBussinessLogger();
    	Logger log2 = Log4j2Utils.getDBLogger();
    	log.error("getExceptionLogger===日志测试");
    	log1.info("getBussinessLogger===日志测试");
    	log2.debug("getDBLogger===日志测试");
    	//Thread.sleep(1000000);
    	Demo d = demoService.get(new Demo());
        return new CommonResult(0000, d, "数据获取成功");
    }

}
