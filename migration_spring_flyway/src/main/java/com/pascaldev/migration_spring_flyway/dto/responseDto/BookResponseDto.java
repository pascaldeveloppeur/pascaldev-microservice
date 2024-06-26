package com.pascaldev.migration_spring_flyway.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class BookResponseDto {

	private Long id;
	private String name;
	private List<String> authorNames;
	private String categoryName;
}
