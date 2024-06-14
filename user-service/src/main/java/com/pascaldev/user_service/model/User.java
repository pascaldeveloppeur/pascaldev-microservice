package com.pascaldev.user_service.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pascal Dev
 */

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements Serializable{
 
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq")
	@SequenceGenerator(name = "school_seq", sequenceName = "school_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@NotNull(message = "name cannot be null")
	@Column(name = "name", length = 20)
	private String name;
	
	@NotNull(message = "email cannot be null")
	@Column(name ="email", unique = true, nullable = false)
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;
}
