package com.project.shopingapp.dto.request;

import com.project.shopingapp.dto.CategoryDto;
import com.project.shopingapp.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductImageRequest {
    private Long productId;
    private String image;
}
