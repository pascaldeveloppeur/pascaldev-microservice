 package com.pascaldev.migration_spring_flyway.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Entity
 @Table(name = "Author")
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
	@SequenceGenerator(name = "author_seq", sequenceName = "author_seq", initialValue = 1, allocationSize = 1)
	private Long id;
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "zipcode_id")
	private ZipCode zipcode;
	
	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Book> books = new ArrayList<>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	public void removeBook(Book book) {
		books.remove(book);
	}

}
