package com.project.shopingapp.dto;

import com.project.shopingapp.model.ProductImage;
import org.springframework.stereotype.Component;

@Component
public class ProductImageDtoConverter {
    public ProductImageDto convert(ProductImage from){

        return new ProductImageDto(from.getImage());
    }

    public static ProductImageDto convertStatic(ProductImage from){

        return new ProductImageDto(from.getImage());
    }


}
