package com.project.shopingapp.dto;

import com.project.shopingapp.model.UserAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAddressDtoConverter {

    public UserAddressDto convert(UserAddress from){

        return new UserAddressDto(from.getAddressText(),
                from.getCity(),
                from.getDistrict());
    }

    public List<UserAddressDto> convert(List<UserAddress> userAddressList){
        return userAddressList.stream().map(this::convert).collect(Collectors.toList());
    }
}
