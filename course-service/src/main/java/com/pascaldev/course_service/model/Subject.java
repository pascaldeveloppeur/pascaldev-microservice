package com.pascaldev.course_service.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject implements Serializable {
	
	
	
	private static final long serialVersionUID = 5384386288364069127L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
	@SequenceGenerator(name = "subject_seq", sequenceName = "subject_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@NotNull(message = "subjectName cannot be null")
	@Column(name = "subjectName", length = 20)
	private String subjectName;
	
	@NotNull(message = "subjectDesription cannot be null")
	@Column(name = "subjectDesription")
	private String subjectDesription;
	
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;

}
