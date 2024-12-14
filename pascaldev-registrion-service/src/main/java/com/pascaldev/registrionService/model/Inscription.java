package com.pascaldev.registrionService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * @author Pascal Dev
 */

@Entity
@Table(name = "inscription")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Inscription implements Serializable {
	
	
	private static final long serialVersionUID = 8037474777554636810L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscription_seq")
	@SequenceGenerator(name = "inscription_seq", sequenceName = "inscription_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "student_name",length = 20)
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name = "classe_id")
	private Classe classe;

}
