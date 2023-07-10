package com.project.shopingapp.dto.request;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequest {
    private Long id;
    private Long categoryId;
    private String productCode;
    private String name;
    private Float price;
    private String description;
}
