package com.project.shopingapp.dto;

import com.project.shopingapp.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDtoConverter {

    public final CategoryDtoConverter categoryDtoConverter;
    public final ProductReviewsDtoConverter productReviewsDtoConverter;
    public final ProductImageDtoConverter productImageDtoConverter;

    public ProductDtoConverter(CategoryDtoConverter categoryDtoConverter, ProductReviewsDtoConverter productReviewsDtoConverter, ProductImageDtoConverter productImageDtoConverter) {
        this.categoryDtoConverter = categoryDtoConverter;
        this.productReviewsDtoConverter = productReviewsDtoConverter;
        this.productImageDtoConverter = productImageDtoConverter;
    }

    public ProductDto convert(Product from){

        CategoryDto categoryDto = categoryDtoConverter.convert(from.getCategory());
        List<ProductReviewsDto> productReviewsDtoList = from.getProductReviews().stream().map(productReviewsDtoConverter::convert).toList();
        List<ProductImageDto> productImageDtoList = from.getProductImages().stream().map(productImageDtoConverter::convert).toList();

        return new ProductDto(categoryDto,
                from.getProductCode(),
                from.getName(),
                from.getPrice(),
                from.getStock(),
                from.getDescription(),
                productReviewsDtoList,
                productImageDtoList);
    }

}
