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
    private UserDto user;
    private String review;
}
