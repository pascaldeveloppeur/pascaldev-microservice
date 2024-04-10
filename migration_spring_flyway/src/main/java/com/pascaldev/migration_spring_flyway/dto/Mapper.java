package com.pascaldev.migration_spring_flyway.dto;

import java.util.ArrayList;
import java.util.List;

import com.pascaldev.migration_spring_flyway.dto.responseDto.AuthorResponseDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.BookResponseDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.CategoryResponseDto;
import com.pascaldev.migration_spring_flyway.models.Author;
import com.pascaldev.migration_spring_flyway.models.Book;
import com.pascaldev.migration_spring_flyway.models.Category;

public class Mapper {
 public static BookResponseDto bookToBookResponseDto(Book book) {
	 BookResponseDto bookResponseDto = new BookResponseDto();
	 bookResponseDto.setId(book.getId());
	 bookResponseDto.setCategoryName(book.getCategory().getName());
	 List<String> names = new ArrayList<>();
	 List<Author> authors = new ArrayList<>();
	 for(Author author: authors) {
		 names.add(author.getName());
	 }
	 bookResponseDto.setAuthorNames(names);
	 return bookResponseDto;
 }
 public static List<BookResponseDto> booksToBookResponseDto(List<Book> books){
	 List<BookResponseDto> bookResponseDtos = new ArrayList<>();
	 for(Book book:books) {
		 bookResponseDtos.add(bookToBookResponseDto(book));
	 }
	 return bookResponseDtos;
 }
 
 public static AuthorResponseDto authorToAuthorResponseDto(Author author) {
	 AuthorResponseDto authorResponseDto = new AuthorResponseDto();
	 authorResponseDto.setId(author.getId());
	 authorResponseDto.setName(author.getName());
	 List<String> names = new ArrayList<>();
	 List<Book> books = author.getBooks();
	 for(Book book : books) {
		 names.add(book.getName());
	 }
	 authorResponseDto.setBookNames(names);
	 return authorResponseDto;
 }
 
 public static List<AuthorResponseDto> authorToAuthorResponseDtos(List<Author> authors){
	 
	 List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
	 for(Author author:authors) {
		 authorResponseDtos.add(authorToAuthorResponseDto(author));
		 
	 }
	 return authorResponseDtos;
 }
 
 public static CategoryResponseDto categoryToCategoryResponseDto(Category category) {
	 CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
	 categoryResponseDto.setId(category.getId());
	 categoryResponseDto.setName(category.getName());
	 List<String> names = new ArrayList<>();
	 List<Book> books = category.getBooks();
	 for(Book book : books) {
		 names.add(book.getName());
	 }
	 categoryResponseDto.setBookNames(names);
	 return categoryResponseDto;
 }
 
 public static List<CategoryResponseDto> categoryToCategoryResponseDtos(List<Category> categorys){
	 
	 List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
	 for(Category category:categorys) {
		 categoryResponseDtos.add(categoryToCategoryResponseDto(category));
		 
	 }
	 return categoryResponseDtos;
 }
}
