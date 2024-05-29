package com.pascaldev.Student.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pascaldev.Student.Entities.Student;
import com.pascaldev.Student.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}

}
