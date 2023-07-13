package com.project.shopingapp.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.shopingapp.model.ProductImage;
import com.project.shopingapp.model.ProductReviews;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ProductDto {
    private CategoryDto category;
    private String productCode;
    private String name;
    private Float price;
    private Integer stock;
    private String description;
    private List<ProductReviewsDto> productReviews;

    private List<ProductImageDto> productImages;
}
