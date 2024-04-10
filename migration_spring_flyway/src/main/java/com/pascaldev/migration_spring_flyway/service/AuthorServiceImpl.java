package com.pascaldev.migration_spring_flyway.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.Mapper;
import com.pascaldev.migration_spring_flyway.dto.request.AuthorRequestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.AuthorResponseDto;
import com.pascaldev.migration_spring_flyway.models.Author;
import com.pascaldev.migration_spring_flyway.models.ZipCode;
import com.pascaldev.migration_spring_flyway.repository.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;
	private final ZipcodeService zipcodeService;
	
	
	@Autowired
	public AuthorServiceImpl(AuthorRepository authorRepository, ZipcodeService zipcodeService) {
		super();
		this.authorRepository = authorRepository;
		this.zipcodeService = zipcodeService;
	}

	@Transactional
	@Override
	public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
		Author author = new Author();
		author.setName(authorRequestDto.getName());
		if(authorRequestDto.getZipcodeId() == null) {
			throw new IllegalArgumentException("author need a zipcode");
		}
		ZipCode zipCode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
		authorRepository.save(author);
		return Mapper.authorToAuthorResponseDto(author);
	}

	@Override
	public List<AuthorResponseDto> getAuthors() {
		List<Author> authors = StreamSupport
				.stream(authorRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Mapper.authorToAuthorResponseDtos(authors);
	}

	@Override
	public AuthorResponseDto getAuthorById(Long authorId) {
		
		return Mapper.authorToAuthorResponseDto(getAuthor(authorId));
	}

	@Override
	public Author getAuthor(Long authorId) {
		Author author = authorRepository.findById(authorId).orElseThrow(() ->
		new IllegalArgumentException("author with id:" + authorId + "could not be found"));
		return author;
	}

	@Override
	public AuthorResponseDto deleteAuthor(Long authorId) {
		Author author = getAuthor(authorId);
		authorRepository.delete(author);
		return Mapper.authorToAuthorResponseDto(author);
	}

	@Transactional
	@Override
	public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
		Author authorToEdit = getAuthor(authorId);
		authorToEdit.setName(authorRequestDto.getName());
		if(authorRequestDto.getZipcodeId() != null) {
			ZipCode zipCode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
			authorToEdit.setZipcode(zipCode);
		}
		return Mapper.authorToAuthorResponseDto(authorToEdit);
	}

	@Transactional
	@Override
	public AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId) {
		Author author = getAuthor(authorId);
		ZipCode zipCode = zipcodeService.getZipcode(zipcodeId);
		if(Objects.nonNull(author.getZipcode())) {
			throw new RuntimeException("author already has a zipcode");
		}
		author.setZipcode(zipCode);
		return Mapper.authorToAuthorResponseDto(author);
	}

	@Transactional  
	@Override
	public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId) {
		Author author = getAuthor(authorId);
		author.setZipcode(null);
		return Mapper.authorToAuthorResponseDto(author);
	}

}
