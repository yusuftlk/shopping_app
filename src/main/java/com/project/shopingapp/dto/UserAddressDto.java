package com.project.shopingapp.dto;
import com.project.shopingapp.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class UserAddressDto {
    private String addressText;
    private String city;
    private String district;
}
