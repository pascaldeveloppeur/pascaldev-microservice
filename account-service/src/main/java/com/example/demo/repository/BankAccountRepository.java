package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
