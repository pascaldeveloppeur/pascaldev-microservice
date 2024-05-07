package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

//@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
		log.info("Customer service started!");
		
	
	}
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepo) {
		
			return args ->{
				List<Customer> customerList= List.of(
						Customer.builder()
							.firstName("pascal")
							.lastName("Yakou")
							.email("pascalyakouyami@gmail.com")
							.build(),
							Customer.builder()
							.firstName("ima")
							.lastName("Sape")
							.email("ima@gmail.com")
							.build() 
						
						);
				customerRepo.saveAll(customerList);
						
			};
	}
}
