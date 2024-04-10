package com.pascaldev.migration_spring_flyway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pascaldev.migration_spring_flyway.dto.request.BookResquestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.BookResponseDto;
import com.pascaldev.migration_spring_flyway.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		
		this.bookService = bookService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<BookResponseDto> addBook(@RequestBody final BookResquestDto resquestDto){
		BookResponseDto bookResponseDto = bookService.addBook(resquestDto);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<BookResponseDto> getCity(@PathVariable final Long id){
		
		BookResponseDto bookResponseDto = bookService.getBookById(id);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BookResponseDto>> getBooks(){
		List<BookResponseDto> bookResponseDtos = bookService.getBooks();
		return new ResponseEntity<>(bookResponseDtos, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BookResponseDto> deleteBook(@PathVariable final Long id){
		BookResponseDto bookResponseDto = bookService.deleteBok(id);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}

	@PostMapping("/edit/{id}")
	public ResponseEntity<BookResponseDto> editBook(@RequestBody final BookResquestDto bookResquestDto,
			@PathVariable final Long id){
		BookResponseDto bookResponseDto = bookService.editBook(id, bookResquestDto);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}
	@PostMapping("/addCategory/{categoryId}/to/{bookId}")
	public ResponseEntity<BookResponseDto> addCategory(@PathVariable final Long categoryId,
			@PathVariable final Long bookId){
		BookResponseDto bookResponseDto = bookService.addCategoryToBook(bookId, categoryId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK); 
	}
	
	@PostMapping("/removeCategory/{categoryId}/from/{bookId}")
	public ResponseEntity<BookResponseDto> removeCategory(@PathVariable final Long categoryId,
			@PathVariable final Long booId){
		BookResponseDto bookResponseDto = bookService.removeCategoryFromBook(booId, categoryId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}
	@PostMapping("/addAuthor/{authorId}/to/{booId}")
	public ResponseEntity<BookResponseDto> addAuthor(@PathVariable final Long authorId,
			@PathVariable final Long booId){
		BookResponseDto bookResponseDto = bookService.addAuthorToBook(booId, authorId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);}
	
	@PostMapping("/removeAuthor/{authorId}/from/{bookId}")
	public ResponseEntity<BookResponseDto> removeAuthor(@PathVariable final Long authorId,
			@PathVariable final Long booId){
		BookResponseDto bookResponseDto = bookService.removeCategoryFromBook(booId, authorId);
		return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
	}
}
