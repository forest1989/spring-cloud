package com.forest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author forest
 *
 */
@EnableEurekaClient
@SpringBootApplication
@Configuration    
@EnableAutoConfiguration
@EnableCaching
public class ForestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForestApplication.class, args);
	}
}
