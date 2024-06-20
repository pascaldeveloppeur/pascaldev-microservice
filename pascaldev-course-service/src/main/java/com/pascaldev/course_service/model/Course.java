package com.pascaldev.course_service.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pascal Dev
 */
@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course implements Serializable {
	
	
	private static final long serialVersionUID = -3598149376138964228L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "course_seq", initialValue = 1, allocationSize = 1)
	private Long id;

	@NotNull(message = "courseName cannot be null")
	@Column(name = "courseName", length = 20)
	private String courseName;
	  
	@OneToMany( mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Subject> subjects;

}
