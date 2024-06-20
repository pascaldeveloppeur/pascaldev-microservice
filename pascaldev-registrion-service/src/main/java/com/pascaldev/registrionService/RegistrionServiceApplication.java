package com.pascaldev.registrionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class RegistrionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrionServiceApplication.class, args);
		log.info("Registration service started!");
	}

}
