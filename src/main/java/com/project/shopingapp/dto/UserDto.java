package com.project.shopingapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class UserDto {
    private String name;
    private String surname;
    private String number;
    private List<UserAddressDto> userAddressDtoList;
}
