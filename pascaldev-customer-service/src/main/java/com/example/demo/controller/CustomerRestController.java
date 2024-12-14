package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerRestController {
	
	
	private final CustomerRepository customerRepository;
	
	
	@GetMapping("/customers")
	public List<Customer> customerList(){
		return customerRepository.findAll();
	} 
	
	@GetMapping("/customers/{id}")
	public Customer customerById(@PathVariable("id") Long id) {
		
			return customerRepository.findById(id).get();
	}

}
