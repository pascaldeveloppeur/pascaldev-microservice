package com.example.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Customer;

@FeignClient(name= "CUSTOMER-SERVICE")
public interface CustomerRestClient {
	
	@GetMapping("/customers/{id}")
	Customer findCustomerById(@PathVariable Long id);
	
	@GetMapping("/customers")
	 List<Customer> allCultomer();

}
