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
import com.pascaldev.migration_spring_flyway.dto.request.CategoryRequestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.BookResponseDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.CategoryResponseDto;
import com.pascaldev.migration_spring_flyway.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody final CategoryRequestDto categoryRequestDto){
		CategoryResponseDto categoryResponseDto = categoryService.addCategory(categoryRequestDto);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CategoryResponseDto> getCity(@PathVariable final Long id){
		
		CategoryResponseDto categoryResponseDto = categoryService.getCategoryById(id);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryResponseDto>> getBooks(){
		List<CategoryResponseDto> categoryResponseDtos = categoryService.getCategories();
		return new ResponseEntity<>(categoryResponseDtos, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CategoryResponseDto> deleteBook(@PathVariable final Long id){
		CategoryResponseDto categoryResponseDto = categoryService.deleteCategory(id);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}

	@PostMapping("/edit/{id}")
	public ResponseEntity<CategoryResponseDto> editBook(@RequestBody final CategoryRequestDto categoryRequestDto,
			@PathVariable final Long id){
		CategoryResponseDto categoryResponseDto = categoryService.editCategory(id, categoryRequestDto);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	
	
}
