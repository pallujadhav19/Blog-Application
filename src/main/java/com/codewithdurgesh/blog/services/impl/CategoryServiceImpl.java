package com.codewithdurgesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.exception.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.repositories.CategoryRepo;
import com.codewithdurgesh.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper; // to convert dto into category and category into dto
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "category Id", categoryId));
				cat.setCategoryTitle(categoryDto.getCategoryTitle());
		        cat.setCategoryDescription(categoryDto.getCategoryDescription());
		        
		        Category updatedCat = this.categoryRepo.save(cat);
		       return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public
	  CategoryDto deleteCategory(Integer categoryId) {
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "category Id", categoryId));
		this.categoryRepo.delete(cat);
		return null;
		
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "category Id", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto> catDtos=categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
