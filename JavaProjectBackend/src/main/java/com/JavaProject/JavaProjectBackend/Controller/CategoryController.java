package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.CategoryDto;
import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
import com.JavaProject.JavaProjectBackend.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryController {
    private ICategoryService _categoryService;
    @Autowired
    public CategoryController(ICategoryService categoryService) {
        _categoryService = categoryService;
    }

    @GetMapping("category")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> countries = _categoryService.getAllCategories();

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(value = "categoryId") int categoryId) {
        CategoryDto category = _categoryService.getCategoryById(categoryId);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }


}
