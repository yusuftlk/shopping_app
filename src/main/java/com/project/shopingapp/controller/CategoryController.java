package com.project.shopingapp.controller;

import com.project.shopingapp.dto.CategoryDto;
import com.project.shopingapp.dto.request.CreateCategoryRequest;
import com.project.shopingapp.model.Category;
import com.project.shopingapp.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){

        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{name}")
    public CategoryDto getCategoryByName(@PathVariable String name){

        return categoryService.getCategoryByName(name);
    }
    @PostMapping()
    public  ResponseEntity<Object> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest){
        return ResponseEntity.ok(categoryService.createCategory(createCategoryRequest));
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

}
