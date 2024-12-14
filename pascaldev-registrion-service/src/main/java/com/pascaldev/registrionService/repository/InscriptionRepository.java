package com.pascaldev.registrionService.repository;

import com.pascaldev.registrionService.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

}
