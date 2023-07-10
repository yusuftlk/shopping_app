package com.project.shopingapp.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCategoryRequest {
    private Long id;
    private String categoryName;

}
