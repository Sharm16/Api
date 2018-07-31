package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qa.service.business.UserService;
import com.qa.utility.JSONUtility;

@SpringBootApplication (scanBasePackages = "com.qa.controller")
public class Application {
	@Bean
	UserService UserServive() {
		return new UserService();
	}
	
	@Bean
	JSONUtility JSONUtil() {
		return new JSONUtility();
	}
	
	static final String topicExchangeName = "spring-boot-exchange";

	static final String queueName = "spring-boot";


	public static void main(String args[]) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}