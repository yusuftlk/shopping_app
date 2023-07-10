package com.project.shopingapp.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserAddressRequest {
    private String addressText;
    private String city;
    private String district;
}
