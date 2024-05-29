package com.pascaldev.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascaldev.Student.Entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
