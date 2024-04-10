 package com.pascaldev.migration_spring_flyway.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
 @Table(name = "Zipcode")
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
public class ZipCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zipcode_seq")
	@SequenceGenerator(name = "zipcode_seq", sequenceName = "zipcode_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "city_id")
	private City city;

}
