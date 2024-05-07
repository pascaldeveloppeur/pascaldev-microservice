package com.example.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.BankAccount;
import com.example.demo.enums.AccountType;
import com.example.demo.repository.BankAccountRepository;

import lombok.extern.slf4j.Slf4j;

@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
		log.info("Account service started!");
	}
	
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository) {
		
			return args ->{
				List<BankAccount> accountList= List.of(
						BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(9800)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(Long.valueOf(1))
						.build(),
						BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(1200)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(Long.valueOf(2))
						.build()
						
						);
				accountRepository.saveAll(accountList);
						
			};
	}

}
