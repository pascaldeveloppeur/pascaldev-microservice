package com.pascaldev.School.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pascaldev.School.Entities.Student;

@FeignClient(name="student-server", url = "http://localhost:8090/api/v1/students")
public interface StudentClient {

	@GetMapping("/school/{school-id}")
	List<Student> findAllStudentsBySchool(@PathVariable("school_id") Long schoolId);
	
}
