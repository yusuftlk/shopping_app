package com.project.shopingapp.dto;
import lombok.*;

import java.time.LocalDateTime;
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
    private UserDto user;
    private UserAddressDto userAddress;
    private ProductDto product;
    private String information;
    private LocalDateTime orderDate;
    private Boolean status;
}
