package com.project.shopingapp.dto;

import com.project.shopingapp.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductDtoConverter {
    public ProductDto convert(Product from){

        CategoryDto categoryDto = new CategoryDto(from.getCategory().getId(),
                from.getCategory().getCategoryName(),
                from.getCategory().getCreationDate(),
                from.getCategory().getStatus());

        return new ProductDto(from.getId(),
                categoryDto,
                from.getProductCode(),
                from.getName(),
                from.getPrice(),
                from.getDescription(),
                LocalDateTime.now(),
                true);
    }

}
