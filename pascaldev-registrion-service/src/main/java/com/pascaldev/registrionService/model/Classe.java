package com.pascaldev.registrionService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pascal Dev
 */

@Entity
@Table(name = "classe")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Classe implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classe_seq")
	@SequenceGenerator(name = "classe_seq", sequenceName = "classe_seq", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscription> inscriptions = new ArrayList<>();

}
