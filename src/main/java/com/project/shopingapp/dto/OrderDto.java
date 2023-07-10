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
public class OrderDto {
    private Long id;
    private Long userId;
    private Long userAddressId;
    private Long productId;
    private String information;
    private Date orderDate;
    private Boolean status;
}
