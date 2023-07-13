package com.project.shopingapp.dto;

import com.project.shopingapp.model.User;
import org.springframework.stereotype.Component;

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
                from.getUserAddresses().stream().map(userAddressDtoConverter::converter)
                        .collect(Collectors.toList()));
    }
}
