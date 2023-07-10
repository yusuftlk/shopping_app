package com.project.shopingapp.dto.request;

import com.project.shopingapp.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserAddressRequest {
    private Long id;
    private Long userId;
    private String addressText;
    private String city;
    private String district;
}
