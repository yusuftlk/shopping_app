package com.project.shopingapp.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class StockDto {
    private Long id;
    private ProductDto product;
    private Integer count;
    private String store;
}
