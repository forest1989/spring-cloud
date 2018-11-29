package com.forest.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author forest
 *
 */
@Service
@FeignClient(name="demo-api")
public interface DemoFeignService {

	@RequestMapping(value="/test/feignTest",method=RequestMethod.GET)
	String helloService();
}
