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
    private Long productId;
    private int count;
    private String store;
}
