package com.project.shopingapp.dto;

import com.project.shopingapp.model.ProductReviews;
import org.springframework.stereotype.Component;

@Component
public class ProductReviewsDtoConverter {
    private final UserDtoConverter userDtoConverter;

    public ProductReviewsDtoConverter( UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public ProductReviewsDto convert(ProductReviews from){
        return new ProductReviewsDto(userDtoConverter.convert(from.getUser()),
                from.getReview());
    }
}
