package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.CategoryDto;
import com.JavaProject.JavaProjectBackend.Interface.ICategoryRepository;
import com.JavaProject.JavaProjectBackend.Interface.ICountryRepository;
import com.JavaProject.JavaProjectBackend.Service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryRepository _categoryRepository;
    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        _categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(int categoryId) {
        return null;
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
}
