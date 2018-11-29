package com.forest.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author forest
 *
 */
@RestController
@RequestMapping(value = "/test")
public class DemoController {

	
	
    @RequestMapping(value="/feignTest", method= RequestMethod.GET)
    public String hello() throws InterruptedException {
    	return "hello, feign";
    }

}
