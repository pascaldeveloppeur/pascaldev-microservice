package com.pascaldev.user_service;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;



@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition
@Slf4j
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		log.info("User service started!");
	}

}
