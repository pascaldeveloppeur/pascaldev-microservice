package com.pascaldev.registrionService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascaldev.registrionService.model.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

}
