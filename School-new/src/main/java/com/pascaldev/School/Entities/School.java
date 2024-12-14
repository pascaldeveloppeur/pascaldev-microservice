package com.pascaldev.School.Entities;



import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Table(name = "school")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School implements Serializable{
	

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq")
	@SequenceGenerator(name = "school_seq", sequenceName = "school_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@NotNull(message = "schoolName cannot be null")
	@Column(name = "schoolName", length = 50)
	private String schoolName;
	
	@NotNull(message = "schoolEmail cannot be null")
	@Column(name ="schoolEmail", unique = true, nullable = false)
	private String schoolEmail;
	
	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
	private ClassRoom classRoom;

}
