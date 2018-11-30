package com.forest.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author forest
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.forest.api.dao")
public class ForestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForestApplication.class, args);
	}
}
