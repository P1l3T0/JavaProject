package com.JavaProject.JavaProjectBackend.Service;
import com.JavaProject.JavaProjectBackend.DTO.CategoryDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(int categoryId);
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, int id);
    void deleteCategory(int id);
}
