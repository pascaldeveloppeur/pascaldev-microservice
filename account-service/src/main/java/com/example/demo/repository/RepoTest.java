package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.BankAccount;

public interface RepoTest extends JpaRepository<BankAccount, Long> {

	@Query("select p from BanckAccount p where p.currensy like :x and p.balance>:y")
	public List<BankAccount> chercherAccounts(
			@Param("x") String currency,
			@Param("y") double balance);
	
}
