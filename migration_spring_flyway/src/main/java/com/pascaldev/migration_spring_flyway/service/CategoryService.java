package com.pascaldev.migration_spring_flyway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.request.CategoryRequestDto;
import com.pascaldev.migration_spring_flyway.dto.responseDto.CategoryResponseDto;
import com.pascaldev.migration_spring_flyway.models.Category;

@Service
public interface CategoryService {

	Category getCategory(Long categoryId);
	CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
	CategoryResponseDto getCategoryById(Long categoruId);
	List<CategoryResponseDto> getCategories();
	CategoryResponseDto deleteCategory(Long categoryId);
	CategoryResponseDto editCategory(Long categoryId,CategoryRequestDto categoryRequestDto);

}
