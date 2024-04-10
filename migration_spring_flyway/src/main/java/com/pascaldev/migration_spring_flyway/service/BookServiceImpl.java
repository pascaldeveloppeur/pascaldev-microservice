package com.pascaldev.migration_spring_flyway.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.Mapper;
import com.pascaldev.migration_spring_flyway.dto.request.BookResquestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.BookResponseDto;
import com.pascaldev.migration_spring_flyway.models.Author;
import com.pascaldev.migration_spring_flyway.models.Book;
import com.pascaldev.migration_spring_flyway.models.Category;
import com.pascaldev.migration_spring_flyway.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final AuthorService authorService;
	private final CategoryService categoryService;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository, AuthorService authorService,
			CategoryService categoryService) {
		super();
		this.bookRepository = bookRepository;
		this.authorService = authorService;
		this.categoryService = categoryService;
	}

	@Transactional
	@Override
	public BookResponseDto addBook(BookResquestDto bookResquestDto) {
		Book book= new Book();
		book.setName(bookResquestDto.getName());
		if(bookResquestDto.getAuthorIds().isEmpty()) {
			throw new IllegalArgumentException("you need atleast on author");
		}else {
			List<Author> authors = new ArrayList<>();
			for(Long authorId: bookResquestDto.getAuthorIds()) {
				Author author = authorService.getAuthor(authorId);
				authors.add(author);
			}
			book.setAuthors(authors);
		}
		if(bookResquestDto.getCategoryId() == null) {
			throw new IllegalArgumentException("book atleast on category");
		}
		Category category = categoryService.getCategory(bookResquestDto.getCategoryId());
		book.setCategory(category); 
		Book book1 = bookRepository.save(book);
		return Mapper.bookToBookResponseDto(book1);
	}

	@Override
	public BookResponseDto getBookById(Long bookId) {
		Book book = getBook(bookId);
		return Mapper.bookToBookResponseDto(book);
	}

	@Override
	public Book getBook(Long bookId) {
		Book book = bookRepository.findById(bookId).orElseThrow(()->
		new IllegalArgumentException("cannot find book with id:" + bookId));
		return book;
	}

	@Override
	public BookResponseDto deleteBok(Long bookId) {
		Book book = getBook(bookId);
		bookRepository.delete(book);
		return Mapper.bookToBookResponseDto(book) ;
	}

	@Override
	public BookResponseDto editBook(Long bookId, BookResquestDto bookResquestDto) {
		Book bookToEdit = getBook(bookId);
		bookToEdit.setName(bookResquestDto.getName());
		if(!bookResquestDto.getAuthorIds().isEmpty()) {
			List<Author> authors = new ArrayList<>();
			for (Long authorId :bookResquestDto.getAuthorIds()) {
				Author author = authorService.getAuthor(authorId);
				authors.add(author);
				
			}
			bookToEdit.setAuthors(authors); 
			}
		if(bookResquestDto.getCategoryId() != null) {
			Category category = categoryService.getCategory(bookResquestDto.getCategoryId());
			bookToEdit.setCategory(category);
		}
		return Mapper.bookToBookResponseDto(bookToEdit);
	}

	@Override
	public BookResponseDto addAuthorToBook(Long bookId, Long authorId) {
		Book book = getBook(bookId);
		Author author = authorService.getAuthor(authorId);
		if(author.getBooks().contains(author)) {
			throw new IllegalArgumentException("this author is already assigned to this book");
			
		}
		book.addAuthor(author);
		author.addBook(book);
		return Mapper.bookToBookResponseDto(book);
	}

	@Override
	public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId) {
		Book book = getBook(bookId);
		Author author = authorService.getAuthor(authorId);
		if(!(author.getBooks().contains(author))) {
			throw new IllegalArgumentException("book does not have this author");
		}
		author.removeBook(book);
		book.deleteAuthor(author);
		return Mapper.bookToBookResponseDto(book);
	}

	@Override
	public BookResponseDto addCategoryToBook(Long bookId, Long categoryId) {
		Book book = getBook(bookId);
		Category category = categoryService.getCategory(categoryId);
		if(Objects.nonNull(book.getCategory())) {
			throw new IllegalArgumentException("book already has a category");
		}
		book.setCategory(category);
		category.addBook(book);
		return Mapper.bookToBookResponseDto(book);
	}

	@Override
	public BookResponseDto removeCategoryFromBook(Long bookId, Long categoryId) {
		Book book = getBook(bookId);
		Category category = categoryService.getCategory(categoryId);
		if(!(Objects.nonNull(book.getCategory()))) {
			throw new IllegalArgumentException("book does not have a category to delete");
		}
		book.setCategory(null);
		category.addBook(book);
		return Mapper.bookToBookResponseDto(book);
	}

	@Override
	public List<BookResponseDto> getBooks() {
		List<Book> books = StreamSupport
				.stream(bookRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Mapper.booksToBookResponseDto(books);
	}

	

}
