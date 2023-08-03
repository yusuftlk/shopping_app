package com.project.shopingapp.dto;

import com.project.shopingapp.model.ProductReviews;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductReviewsDto> convert(List<ProductReviews> productReviewsList){
        return productReviewsList.stream().map(this::convert).collect(Collectors.toList());
    }
}
