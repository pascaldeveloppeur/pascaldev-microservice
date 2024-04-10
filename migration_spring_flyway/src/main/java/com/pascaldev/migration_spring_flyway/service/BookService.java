package com.pascaldev.migration_spring_flyway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.request.BookResquestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.BookResponseDto;
import com.pascaldev.migration_spring_flyway.models.Book;

@Service
public interface BookService {
	public BookResponseDto addBook(BookResquestDto bookResquestDto);
	public BookResponseDto getBookById(Long bookId);
	public Book getBook(Long bookId);
	public List<BookResponseDto> getBooks();
	public BookResponseDto deleteBok(Long bookId);
	public BookResponseDto editBook(Long bookId,BookResquestDto bookResquestDto);
	public BookResponseDto addAuthorToBook(Long bookId,Long authorId);
	public BookResponseDto deleteAuthorFromBook(Long bookId,Long authorId);
	public BookResponseDto addCategoryToBook(Long bookId,Long category);
	public BookResponseDto removeCategoryFromBook(Long bookId,Long category);

}
