package com.example.demo.entities;

import java.time.LocalDate;

import com.example.demo.enums.AccountType;
import com.example.demo.model.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
	
	@Id
	private String accountId;
	private double balance;
	private LocalDate createAt; 
	private String currency;
	
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	//ne pas enreegistrer cet attribut en BD
	@Transient
	private Customer customer;
	private Long customerId; 
	

}
