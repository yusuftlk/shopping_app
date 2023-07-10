package com.project.shopingapp.service;

import com.project.shopingapp.dto.CategoryDto;
import com.project.shopingapp.dto.CategoryDtoConverter;
import com.project.shopingapp.dto.request.CreateCategoryRequest;
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
        return categoryList.stream().map(categoryDtoConverter::convert).collect(Collectors.toList());
    }

    protected Category findCustomerById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(null);
        return category;
    }
    public CategoryDto getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(null);
        return categoryDtoConverter.convert(category);
    }

    public CategoryDto createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category(createCategoryRequest.getId(),
                createCategoryRequest.getCategoryName(),
                LocalDateTime.now(),
                true);
        return categoryDtoConverter.convert(categoryRepository.save(category));
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}