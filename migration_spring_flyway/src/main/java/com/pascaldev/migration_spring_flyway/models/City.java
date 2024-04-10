package com.pascaldev.migration_spring_flyway.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "City")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
	@SequenceGenerator(name = "city_seq", sequenceName = "city_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	private String name;

}
