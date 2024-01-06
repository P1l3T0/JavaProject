package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.CategoryDto;
import com.JavaProject.JavaProjectBackend.ErrorHandling.CategoryNotFoundException;
import com.JavaProject.JavaProjectBackend.ErrorHandling.CountryNotFoundException;
import com.JavaProject.JavaProjectBackend.Interface.ICategoryRepository;
import com.JavaProject.JavaProjectBackend.Models.Category;
import com.JavaProject.JavaProjectBackend.Service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private ICategoryRepository _categoryRepository;
    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        _categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = _categoryRepository.findAll();
        List<CategoryDto> response = categories.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        return response;
    }

    @Override
    public CategoryDto getCategoryById(int categoryId) {
        Category category = _categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist!"));

        return  mapToDto(category);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
        return null;
    }

    @Override
    public void deleteCategory(int id) {

    }

    private CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        return categoryDto;
    }
}
