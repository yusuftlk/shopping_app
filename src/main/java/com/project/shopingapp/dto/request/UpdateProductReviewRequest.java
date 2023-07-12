package com.project.shopingapp.dto.request;

import com.project.shopingapp.dto.ProductDto;
import com.project.shopingapp.dto.UserDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductReviewRequest {
    private String review;
}
