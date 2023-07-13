package com.project.shopingapp.dto.request;

import com.project.shopingapp.dto.ProductDto;
import com.project.shopingapp.dto.UserDto;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductReviewRequest {
    private Long productId;
    private Long userId;
    private String review;
}
