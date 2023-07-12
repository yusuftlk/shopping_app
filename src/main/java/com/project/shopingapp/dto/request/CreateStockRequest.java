package com.project.shopingapp.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStockRequest {
    private Long id;
    private Long ProductId;
    private Integer count;
    private String store;
}
