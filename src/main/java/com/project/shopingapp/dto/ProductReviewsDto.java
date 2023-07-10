package com.project.shopingapp.dto;

import lombok.*;

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
    private Long productId;
    private Long userId;
    private String review;
    private Date creationDate;
    private Boolean status;
}
