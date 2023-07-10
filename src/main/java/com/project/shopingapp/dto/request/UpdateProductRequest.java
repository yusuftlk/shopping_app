package com.project.shopingapp.dto.request;

import com.project.shopingapp.dto.CategoryDto;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductRequest {
    private Long categoryId;
    private String productCode;
    private String name;
    private Float price;
    private String description;

}
