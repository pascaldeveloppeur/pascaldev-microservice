package com.pascaldev.migration_spring_flyway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.request.AuthorRequestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.AuthorResponseDto;
import com.pascaldev.migration_spring_flyway.models.Author;

@Service
public interface AuthorService {
	
	public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
	public List<AuthorResponseDto> getAuthors();
	public AuthorResponseDto getAuthorById(Long authorId);
	public Author getAuthor(Long authorId);
	public AuthorResponseDto deleteAuthor(Long authorId);
	public AuthorResponseDto editAuthor(Long authorId,AuthorRequestDto authorRequestDto);
	public AuthorResponseDto addZipcodeToAuthor(Long authorId,Long zipcodeId);
	public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId);

}
