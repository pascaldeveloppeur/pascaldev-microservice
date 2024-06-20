package com.pascaldev.course_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pascaldev.course_service.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
