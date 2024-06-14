package com.pascaldev.course_service.dto;

import java.util.List;

import com.pascaldev.course_service.model.Subject;

import lombok.Data;

@Data
public class CourseDto {
	
	private Long id;
	private String courseName;
	private List<Subject> subjects;

}
