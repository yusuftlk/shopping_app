package com.project.shopingapp.dto;

import com.project.shopingapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User from) {
        return new UserDto(from.getId(),
                from.getName(),
                from.getSurname(),
                from.getNumber(),
                from.getCreationDate(),
                from.getStatus());
    }
}
