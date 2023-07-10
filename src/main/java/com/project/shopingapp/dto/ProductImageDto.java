package com.project.shopingapp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ProductImageDto {

    private Long id;
    private Long productId;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
}
