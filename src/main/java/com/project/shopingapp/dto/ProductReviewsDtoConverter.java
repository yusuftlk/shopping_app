package com.project.shopingapp.dto;

import com.project.shopingapp.model.ProductReviews;
import org.springframework.stereotype.Component;

@Component
public class ProductReviewsDtoConverter {
    private final ProductDtoConverter productDtoConverter;
    private final UserDtoConverter userDtoConverter;

    public ProductReviewsDtoConverter(ProductDtoConverter productDtoConverter, UserDtoConverter userDtoConverter) {
        this.productDtoConverter = productDtoConverter;
        this.userDtoConverter = userDtoConverter;
    }

    public ProductReviewsDto convert(ProductReviews from){
        return new ProductReviewsDto(from.getId(),
                productDtoConverter.convert(from.getProduct()),
                userDtoConverter.convert(from.getUser()),
                from.getReview(),
                from.getCreationDate(),
                from.getStatus());
    }
}
