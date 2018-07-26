package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.qa.controller")
public class Application {
	
	static final String topicExchangeName = "spring-boot-exchange";

	static final String queueName = "spring-boot";


	public static void main(String args[]) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}