package com.pascaldev.user_service.model;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class UserException extends RuntimeException {

	private int statusCode;

	public UserException() {
		
		this.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
    public UserException(String message) {
		
		this(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
    
    public UserException(String message, Object... args) {
		
		this(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageFormatter.arrayFormat(message, args).getMessage());
	}
	
	

	public UserException(int statutCode, String message) {
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
