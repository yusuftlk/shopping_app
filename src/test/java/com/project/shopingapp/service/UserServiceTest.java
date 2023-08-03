package com.project.shopingapp.service;

import com.project.shopingapp.dto.UserAddressDto;
import com.project.shopingapp.dto.UserAddressDtoConverter;
import com.project.shopingapp.dto.UserDto;
import com.project.shopingapp.dto.UserDtoConverter;
import com.project.shopingapp.dto.request.CreateUserRequest;
import com.project.shopingapp.dto.request.UpdateUserRequest;
import com.project.shopingapp.exception.UserNotFoundException;
import com.project.shopingapp.model.User;
import com.project.shopingapp.model.UserAddress;
import com.project.shopingapp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;
    private UserDtoConverter userDtoConverter;
    private UserAddressDtoConverter userAddressDtoConverter;
    @BeforeEach
    public void setUp(){
        userRepository = mock(UserRepository.class);
        userDtoConverter = mock(UserDtoConverter.class);
        userAddressDtoConverter = mock(UserAddressDtoConverter.class);
        userService = new UserService(userRepository, userDtoConverter);
    }
    @Test
    public void whenCreateUserCalledWithValidRequest_itShouldReturnValidUserDto(){


        CreateUserRequest createUserRequest = new CreateUserRequest("name",
                "surname",
                "number",
                "email",
                "password");

        User user = new User(createUserRequest.getName(),
                createUserRequest.getSurname(),
                createUserRequest.getNumber(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                LocalDateTime.now(),
                true);

        UserAddress userAddress = new UserAddress(user, "addresstext",
                "city",
                "district");

        user.getUserAddresses().add(userAddress);

        UserAddressDto userAddressDto = new UserAddressDto("addresstext",
                "city",
                "district");

        UserDto userDto = new UserDto("name",
                "surname",
                "number",
                List.of(userAddressDto));


        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(userDtoConverter.convert(user)).thenReturn(userDto);
        Mockito.when(userAddressDtoConverter.convert(userAddress)).thenReturn(userAddressDto);

        UserDto result = userService.createUser(createUserRequest);

        assertEquals(result, userDto);

    }
    @Test
    public void testGetUserById_whenUserIdExists_shouldReturnUserDto(){

        User user = new User(1L,
                "name",
                "surname",
                "number",
                "email",
                "password",
                LocalDateTime.now(),
                true,
                new ArrayList<>());

        UserDto userDto = new UserDto("name",
                "surname",
                "number",
                new ArrayList<>());

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userDtoConverter.convert(user)).thenReturn(userDto);

        UserDto result = userService.getUserById(1L);

        Assertions.assertEquals(result, userDto);

        Mockito.verify(userRepository).findById(1L);
        Mockito.verify(userDtoConverter).convert(user);

    }

    @Test
    public void testGetUserById_whenUserIdDoesNotExist_shouldThrowUserNotFoundException(){

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
    }

    @Test
    public void testUpdateUser_whenUserIdExist_shouldReturnUserDto(){
        UpdateUserRequest updateUserRequest = new UpdateUserRequest("name_new",
                "surname_new",
                "number_new",
                "password_new");

        User user = new User(1L,
                "name",
                "surname",
                "number",
                "email",
                "password",
                LocalDateTime.now(),
                true,
                new ArrayList<>());


        User updatedUser = new User(1L,
                "name_new",
                "surname_new",
                "number_new",
                "email_new",
                "password_new",
                user.getCreationDate(),
                user.getStatus(),
                user.getUserAddresses());

        UserDto userDto = new UserDto("name_new",
                "surname_new",
                "number_new",
                new ArrayList<>());



        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(updatedUser)).thenReturn(updatedUser);
        Mockito.when(userDtoConverter.convert(updatedUser)).thenReturn(userDto);

        UserDto result = userService.updateUser(1L,updateUserRequest);

        Assertions.assertEquals(result, userDto);

        Mockito.verify(userRepository).save(updatedUser);
        Mockito.verify(userDtoConverter).convert(updatedUser);
        Mockito.verify(userService).findUserById(1L);



    }


}