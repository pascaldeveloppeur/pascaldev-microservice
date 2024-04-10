package com.pascaldev.migration_spring_flyway.dto.request;

import lombok.Data;

@Data 
public class AuthorRequestDto {

	private  String name;
	private Long zipcodeId;
}
