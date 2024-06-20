package com.pascaldev.course_service.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.pascaldev.course_service.model.Course;
import com.pascaldev.course_service.model.Subject;

import lombok.Data;

@Data
public class SubjectDto {
	
	private Long id;
	private String subjectName;
	private String subjectDesription;
	private CourseDto courseDto;
	
	public static SubjectDto fromSubject(Subject subject) {

		ModelMapper modelMapper = new ModelMapper();
		SubjectDto subjectDto = modelMapper.map(subject, SubjectDto.class);
		return subjectDto;
	}

	public static Subject fromSubjectDto(SubjectDto subjectDto) {
		ModelMapper modelMapper = new ModelMapper();
		Subject subject = modelMapper.map(subjectDto, Subject.class);
		return subject;
	}

}
