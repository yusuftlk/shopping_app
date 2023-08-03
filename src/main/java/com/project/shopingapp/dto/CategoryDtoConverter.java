package com.project.shopingapp.dto;

import com.project.shopingapp.model.Category;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDtoConverter {
    public CategoryDto convert(Category from){

        return new CategoryDto(from.getCategoryName());
    }

    public List<CategoryDto> convert(List<Category> categoryList){
        return categoryList.stream().map(this::convert).collect(Collectors.toList());
    }
}
