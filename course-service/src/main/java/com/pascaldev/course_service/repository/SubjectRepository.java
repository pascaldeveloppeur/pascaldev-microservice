package com.pascaldev.course_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascaldev.course_service.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
