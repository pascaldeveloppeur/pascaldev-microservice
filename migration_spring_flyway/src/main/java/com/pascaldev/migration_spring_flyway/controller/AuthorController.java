package com.pascaldev.migration_spring_flyway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pascaldev.migration_spring_flyway.dto.request.AuthorRequestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.AuthorResponseDto;
import com.pascaldev.migration_spring_flyway.service.AuthorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/author")
public class AuthorController {
	
	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		
		this.authorService = authorService;
	}
	
	@PostMapping("/addAuthor")
	public ResponseEntity<AuthorResponseDto > postMethodName(@RequestBody final AuthorRequestDto authorRequestDto) {
		AuthorResponseDto authorResponseDto = authorService.addAuthor(authorRequestDto);
		
		
		return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable final Long id){
		AuthorResponseDto authorResponseDto = authorService.getAuthorById(id);
		return new ResponseEntity<>(authorResponseDto, HttpStatus.OK); 
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AuthorResponseDto>> getAuthors(){
		List<AuthorResponseDto> authorResponseDtos = authorService.getAuthors();
		return new ResponseEntity<>(authorResponseDtos, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable final Long id){
		AuthorResponseDto authorResponseDto = authorService.deleteAuthor(id);
		return new ResponseEntity<>(authorResponseDto, HttpStatus.OK); 
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable final Long id,
			@RequestBody final AuthorRequestDto authorRequestDto){
		AuthorResponseDto authorResponseDto = authorService.editAuthor(id, authorRequestDto);
		return new ResponseEntity<>(authorResponseDto, HttpStatus.OK); 
	}
	
	@PostMapping("/addZipcode/{zipcodeId}/to/{authorId}")
	public ResponseEntity<AuthorResponseDto>  addZipcode(@PathVariable final Long zipcodeId,
			@PathVariable final Long authorId){
		AuthorResponseDto authorResponseDto = authorService.addZipcodeToAuthor(authorId, zipcodeId);
		return new ResponseEntity<>(authorResponseDto, HttpStatus.OK); 
	}
	
	@PostMapping("/removeZipcode/{id}")
	public ResponseEntity<AuthorResponseDto> removeZipcode(@PathVariable final Long id){
		AuthorResponseDto authorResponseDto = authorService.deleteZipcodeFromAuthor(id);
		return new ResponseEntity<>(authorResponseDto, HttpStatus.OK); 
	}

}
