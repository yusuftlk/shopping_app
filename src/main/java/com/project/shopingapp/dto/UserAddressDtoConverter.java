package com.project.shopingapp.dto;

import com.project.shopingapp.model.UserAddress;
import org.springframework.stereotype.Component;

@Component
public class UserAddressDtoConverter {
    public UserAddressDto converter(UserAddress from){
        UserDto userDto = new UserDto(from.getUser().getId(),
                from.getUser().getName(),
                from.getUser().getSurname(),
                from.getUser().getNumber(),
                from.getUser().getCreationDate(),
                from.getUser().getStatus());
        return new UserAddressDto(from.getId(),
                userDto,
                from.getAddressText(),
                from.getCity(),
                from.getDistrict());
    }
}
