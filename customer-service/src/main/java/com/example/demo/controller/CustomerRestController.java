package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> customerList(){
		return customerRepository.findAll();
	} 
	
	@GetMapping("/customer/{id}")
	public Customer customerById(@PathVariable Long id) {
		
			return customerRepository.findById(id).get();
	}

}
