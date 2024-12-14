package com.pascaldev.School.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pascaldev.School.Client.StudentClient;
import com.pascaldev.School.Entities.FullSchoolResponse;
import com.pascaldev.School.Entities.School;
import com.pascaldev.School.Repository.SchoolRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
	
	private final SchoolRepository schoolRepository;
	private StudentClient studentClient;
	
	public void saveSchool(School school) {
		schoolRepository.save(school);
	}
	
	public List<School> findAllSchools(){
		return schoolRepository.findAll();
	}

	public FullSchoolResponse findAllSchoolsWithStudents(Long schoolId) {
		
		var school = schoolRepository.findById(schoolId)
				.orElse(School.builder()
				.schoolName("NOT_FOUND")
				.schoolEmail("NOT_FOUND")
			    .build());
		var students = studentClient.findAllStudentsBySchool(schoolId);
		return FullSchoolResponse.builder()
				.name(school.getSchoolName())
				.email(school.getSchoolEmail())
				.students(students)
				.build();
	}

}
