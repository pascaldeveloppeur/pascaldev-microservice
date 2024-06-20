package com.pascaldev.registrionService.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	
	
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name = "classe_id")
	private Classe classe;

}
