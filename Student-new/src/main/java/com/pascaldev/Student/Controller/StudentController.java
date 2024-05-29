package com.pascaldev.Student.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pascaldev.Student.Entities.Student;
import com.pascaldev.Student.Service.StudentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentService studentService;
	
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Student student) {
		
		
		 studentService.saveStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> findAllStudents(){
		return ResponseEntity.ok(studentService.findAllStudents());
	}
	
	

}
