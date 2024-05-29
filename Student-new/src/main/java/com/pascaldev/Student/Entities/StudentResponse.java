package com.pascaldev.Student.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;

}
