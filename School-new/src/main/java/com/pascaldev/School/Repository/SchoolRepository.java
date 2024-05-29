package com.pascaldev.School.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascaldev.School.Entities.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
