package com.pascaldev.migration_spring_flyway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pascaldev.migration_spring_flyway.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
