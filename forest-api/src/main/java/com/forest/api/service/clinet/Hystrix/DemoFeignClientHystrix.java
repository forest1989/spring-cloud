package com.forest.api.service.clinet.Hystrix;

import org.springframework.stereotype.Component;

import com.forest.api.service.clinet.DemoFeignService;

@Component
public class DemoFeignClientHystrix implements DemoFeignService{

	@Override
	public String helloService() {
		
		return "此方法异常啦....";
	}

}
