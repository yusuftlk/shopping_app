package com.project.shopingapp.dto;

import com.project.shopingapp.model.Product;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ProductReviewsDto {
    private Long id;
    private ProductDto product;
    private UserDto user;
    private String review;
    private LocalDateTime creationDate;
    private Boolean status;
}
