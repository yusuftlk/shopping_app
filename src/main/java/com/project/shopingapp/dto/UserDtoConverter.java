package com.project.shopingapp.dto;

import com.project.shopingapp.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    private final UserAddressDtoConverter userAddressDtoConverter;

    public UserDtoConverter(UserAddressDtoConverter userAddressDtoConverter) {
        this.userAddressDtoConverter = userAddressDtoConverter;
    }

    public UserDto convert(User from) {

        return new UserDto(
                from.getName(),
                from.getSurname(),
                from.getNumber(),
                userAddressDtoConverter.convert(from.getUserAddresses()));
    }

    public List<UserDto> convert(List<User> userList){

        return userList.stream().map(this::convert).collect(Collectors.toList());
    }


}
