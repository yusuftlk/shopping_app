package com.project.shopingapp.service;

import com.project.shopingapp.dto.CategoryDto;
import com.project.shopingapp.dto.CategoryDtoConverter;
import com.project.shopingapp.dto.request.CreateCategoryRequest;
import com.project.shopingapp.exception.CategoryNotFoundException;
import com.project.shopingapp.model.Category;
import com.project.shopingapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConverter = categoryDtoConverter;
    }

    public List<CategoryDto> getAllCategories (){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryDtoConverter.convert(categoryList);
    }

    protected Category findCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException("Category Not Found id = " + id));
        return category;
    }

    public CategoryDto createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category(null,
                createCategoryRequest.getCategoryName(),
                LocalDateTime.now(),
                true);
        return categoryDtoConverter.convert(categoryRepository.save(category));
    }
    public void deleteCategory(Long id) {
        findCategoryById(id);
        categoryRepository.deleteById(id);
    }

    public CategoryDto getCategoryByName(String name) {
        Category category = categoryRepository.findByCategoryName(name);

        return categoryDtoConverter.convert(category);
    }
}
