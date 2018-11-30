package com.forest.api.service.clinet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forest.api.service.clinet.Hystrix.DemoFeignClientHystrix;

/**
 * 
 * @author forest
 *
 */
@Service
@FeignClient(name="demo-api", fallback = DemoFeignClientHystrix.class)
public interface DemoFeignService {

	@RequestMapping(value="/test/feignTest",method=RequestMethod.GET)
	String helloService();
}
