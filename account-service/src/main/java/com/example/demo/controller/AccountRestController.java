package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BankAccount;
import com.example.demo.repository.BankAccountRepository;

@RestController
public class AccountRestController {
	
	private BankAccountRepository accountRepository;
	
	public AccountRestController(BankAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@GetMapping("/accounts")
	public List<BankAccount> accountList(){
		return accountRepository.findAll();
	} 
	
	@GetMapping("/accounts/{id}")
	public BankAccount bankAccountById(@PathVariable String id) {
		
			return accountRepository.findById(id).get(); 
	}

}
