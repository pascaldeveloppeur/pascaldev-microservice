package org.dev.model;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class MemberException extends RuntimeException {
	
	private int statusCode;

	public MemberException() {
		
		this.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
    public MemberException(String message) {
		
		this(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
    
    public MemberException(String message, Object... args) {
		
		this(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageFormatter.arrayFormat(message, args).getMessage());
	}
	
	

	public MemberException(int statutCode, String message) {
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
