package com.project.shopingapp.dto;

import com.project.shopingapp.model.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ProductImageDto {
    private String image;
}
