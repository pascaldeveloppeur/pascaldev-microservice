package com.pascaldev.migration_spring_flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pascaldev.migration_spring_flyway.models.ZipCode;

@Repository
public interface ZipcodeRepository extends JpaRepository<ZipCode, Long>{

}
