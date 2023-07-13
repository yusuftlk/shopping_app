package com.project.shopingapp.dto;

import com.project.shopingapp.model.UserAddress;
import org.springframework.stereotype.Component;

@Component
public class UserAddressDtoConverter {

    public UserAddressDto converter(UserAddress from){

        return new UserAddressDto(from.getAddressText(),
                from.getCity(),
                from.getDistrict());
    }
}
