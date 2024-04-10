package com.pascaldev.migration_spring_flyway.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.Mapper;
import com.pascaldev.migration_spring_flyway.dto.request.CategoryRequestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.CategoryResponseDto;
import com.pascaldev.migration_spring_flyway.models.Category;
import com.pascaldev.migration_spring_flyway.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category getCategory(Long categoryId) {
		
		return categoryRepository.findById(categoryId).orElseThrow(() ->
		new IllegalArgumentException("could not find category with id:" + categoryId));
	}

	@Override
	public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
		  Category category = new Category();
		  category.setName(categoryRequestDto.getName());
		  categoryRepository.save(category);
		return Mapper.categoryToCategoryResponseDto(category);
	}

	@Override
	public CategoryResponseDto getCategoryById(Long categoruId) {
		Category category = getCategory(categoruId);
		return Mapper.categoryToCategoryResponseDto(category);
	}

	@Override
	public List<CategoryResponseDto> getCategories() {
		List<Category> categories = StreamSupport
				.stream(categoryRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Mapper.categoryToCategoryResponseDtos(categories);
	}

	@Override
	public CategoryResponseDto deleteCategory(Long categoryId) {
		Category category = getCategory(categoryId);
		categoryRepository.delete(category);
		return Mapper.categoryToCategoryResponseDto(category);
	}

	@Override
	public CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto) {
		Category categoryToEdit = getCategory(categoryId);
		categoryToEdit.setName(categoryRequestDto.getName());
		return Mapper.categoryToCategoryResponseDto(categoryToEdit);
	}

}
