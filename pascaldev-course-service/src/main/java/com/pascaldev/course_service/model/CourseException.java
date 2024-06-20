package com.pascaldev.course_service.model;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class CourseException extends RuntimeException {

	private int statusCode;

	public CourseException() {
		
		this.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
    public CourseException(String message) {
		
		this(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
    
    public CourseException(String message, Object... args) {
		
		this(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageFormatter.arrayFormat(message, args).getMessage());
	}
	
	

	public CourseException(int statutCode, String message) {
		super(message);
		this.setStatusCode(statutCode);
	}
	
	

	

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		
	}
}
