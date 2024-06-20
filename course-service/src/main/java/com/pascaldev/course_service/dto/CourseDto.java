package com.pascaldev.course_service.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.pascaldev.course_service.model.Course;
import com.pascaldev.course_service.model.Subject;

import lombok.Data;

@Data
public class CourseDto {
	
	private Long id;
	private String courseName;
	//private List<Subject> subjects;
	
	public static CourseDto fromCourse(Course course) {

		ModelMapper modelMapper = new ModelMapper();
		CourseDto courseDto = modelMapper.map(course, CourseDto.class);
		return courseDto;
	}

	public static Course fromUserDto(CourseDto userDto) {
		ModelMapper modelMapper = new ModelMapper();
		Course course = modelMapper.map(userDto, Course.class);
		return course;
	}

}
