package com.pascaldev.migration_spring_flyway.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class BookResquestDto {

	private String name;
	private List<Long> authorIds;
	private Long categoryId;
}
