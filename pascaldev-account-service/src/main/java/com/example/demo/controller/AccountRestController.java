package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.clients.CustomerRestClient;
import com.example.demo.entities.BankAccount;
import com.example.demo.model.Customer;
import com.example.demo.repository.BankAccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class AccountRestController {
	
	private final BankAccountRepository accountRepository;
	private final CustomerRestClient customerRestClient;
	
	
	
	@GetMapping("/accounts")
	public List<BankAccount> accountList(){
		return accountRepository.findAll();
	} 
	
	@GetMapping("/accounts/{id}")
	public BankAccount bankAccountById(@PathVariable("id") Long id) {
		
		BankAccount account = accountRepository.findById(id).get(); 
		Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
		account.setCustomer(customer);
		return account;
	}

}
