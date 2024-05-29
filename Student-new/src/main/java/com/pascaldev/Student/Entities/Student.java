package com.pascaldev.Student.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pascal Dev
 */

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "FirstName cannot be null")
	@Column(name = "firstName",length = 20)
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	@Column(name = "lastname",length = 20)
	private String lastname;
	
	@Email(message = "Email should be valid")
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	private Long schoolId;

}
