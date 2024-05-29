package com.example.demo.entities;

import java.time.LocalDate;

import com.example.demo.enums.AccountType;
import com.example.demo.model.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_seq", initialValue = 1, allocationSize = 1)
	private Long id;
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
