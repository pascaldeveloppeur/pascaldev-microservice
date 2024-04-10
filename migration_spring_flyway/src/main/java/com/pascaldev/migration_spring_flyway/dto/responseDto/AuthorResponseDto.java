package com.pascaldev.migration_spring_flyway.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class AuthorResponseDto {

	private Long id;
	private String name;
	private List<String> bookNames;
	private String zipcodeName;
}
