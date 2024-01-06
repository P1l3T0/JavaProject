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

    @PostMapping("category/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto response = _categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("category/{categoryId}/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryDto> updatePokemon(@RequestBody CategoryDto categoryDto, @PathVariable("categoryId") int categoryId) {
        CategoryDto response = _categoryService.updateCategory(categoryDto, categoryId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("category/{categoryId}/delete")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int categoryId) {
        _categoryService.deleteCategory(categoryId);

        return new ResponseEntity<>("Category deleted", HttpStatus.OK);
    }
}
