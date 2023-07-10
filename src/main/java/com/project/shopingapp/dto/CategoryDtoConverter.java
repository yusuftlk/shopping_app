package com.project.shopingapp.dto;

import com.project.shopingapp.model.Category;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CategoryDtoConverter {
    public CategoryDto convert(Category from){
        return new CategoryDto(from.getId(), from.getCategoryName(), LocalDateTime.now(), true);
    }
}
