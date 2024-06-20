package com.pascaldev.course_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pascaldev.course_service.dto.CourseDto;
import com.pascaldev.course_service.dto.SubjectDto;
import com.pascaldev.course_service.serviceImpl.CourserServiceImpl;
import com.pascaldev.pascaldev_utild_service.model.PascalDevException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/courses")
@Slf4j
@RequiredArgsConstructor
public class CourseController {
	
	private final CourserServiceImpl courserServiceImpl;
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getCourse(@PathVariable("id") Long id) {

		log.debug("Call of get course by id : {}", id);

		try {
			log.trace("Found : {}", "");
			CourseDto courseDto = courserServiceImpl.getById(id);

			return ResponseEntity.status(HttpStatus.OK).body(courseDto);
		} catch (PascalDevException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllCourses(){
		 log.debug("Call of get course  : {}");
			
			try {
				log.trace("Found : {}", "");
				List<CourseDto> courseDtos = courserServiceImpl.getAll();
				return  ResponseEntity.status(HttpStatus.OK).body(courseDtos);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createCourse(@RequestBody CourseDto courseDto){
		
		  log.debug("Call of create course : {}", courseDto);
			
			try {
				log.trace("Save : {}", "");
				CourseDto newCourseDto = courserServiceImpl.save(courseDto);
				return  ResponseEntity.status(HttpStatus.OK).body(newCourseDto);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CourseDto> updateUser(@PathVariable("id") Long id, @RequestBody CourseDto courseDto){
		
		 log.debug("Call of update course : {}", id);
			try {
				CourseDto newCourseDto = courserServiceImpl.update(id, courseDto);
				return new ResponseEntity<>(newCourseDto, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		 log.debug("Call of delete course : {}", id);
			
			try {
				
				courserServiceImpl.deleteById(id);
				return  ResponseEntity.status(HttpStatus.OK).body(true);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
	}
	
	@DeleteMapping("/delete-all")
	public ResponseEntity<?> deleteAlls(){
		 log.debug("Call of delete all ");
			try {
				courserServiceImpl.deleteAll();
				return  ResponseEntity.status(HttpStatus.OK).body(true);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@GetMapping("/subjects")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllSubjects() {
		 log.debug("Call of get subject  : {}");
			
			try {
				log.trace("Found : {}", "");
				List<SubjectDto> subjectDtos = courserServiceImpl.getAllSubjects();
				return  ResponseEntity.status(HttpStatus.OK).body(subjectDtos);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
    }

    @GetMapping("/subjects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getSubjectById(@PathVariable("id") Long id) {
    	log.debug("Call of get subject by id : {}", id);

		try {
			log.trace("Found : {}", "");
			SubjectDto subjectDto = courserServiceImpl.getSubjectById(id);

			return ResponseEntity.status(HttpStatus.OK).body(subjectDto);
		} catch (PascalDevException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
    }

    @PostMapping("/subjects")
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createSubject(@RequestBody SubjectDto subjectDto) {
    	 log.debug("Call of create subject : {}", subjectDto);
			
			try {
				log.trace("Save : {}", "");
				SubjectDto newSubjectDto = courserServiceImpl.createSubject(subjectDto);
				return  ResponseEntity.status(HttpStatus.OK).body(newSubjectDto);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable("id") Long id, @RequestBody SubjectDto subjectDto) {
    	log.debug("Call of update subject : {}", id);
		try {
			SubjectDto newSubjectDto = courserServiceImpl.updateSubject(id, subjectDto);
			return new ResponseEntity<>(newSubjectDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable("id") Long id) {
    	log.debug("Call of delete subject : {}", id);
		
		try {
			
			courserServiceImpl.deleteById(id);
			return  ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (PascalDevException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
    }

}
