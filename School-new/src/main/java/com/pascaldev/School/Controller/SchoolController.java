package com.pascaldev.School.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pascaldev.School.Entities.FullSchoolResponse;
import com.pascaldev.School.Entities.School;
import com.pascaldev.School.Service.SchoolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SchoolController {
	
private final SchoolService schoolService;
	
	
	@PostMapping("/") 
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody School school) {
		
		
		schoolService.saveSchool(school);
	}
	
	@GetMapping("/schools")
	public ResponseEntity<List<School>> findAllSchools(){
		return ResponseEntity.ok(schoolService.findAllSchools());
	}
	
	@GetMapping("/schools/{schoolId}")
	public ResponseEntity<?> findSchoolById(
			@PathVariable("schoolId") Long schoolId){
		
		return ResponseEntity.ok(schoolService.findAllSchoolsWithStudents(schoolId));
	}

}
