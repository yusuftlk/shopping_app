package com.project.shopingapp.service;

import com.project.shopingapp.dto.UserDto;
import com.project.shopingapp.dto.UserDtoConverter;
import com.project.shopingapp.dto.request.CreateUserRequest;
import com.project.shopingapp.dto.request.UpdateUserRequest;
import com.project.shopingapp.exception.UserNotFoundException;
import com.project.shopingapp.model.User;
import com.project.shopingapp.model.UserAddress;
import com.project.shopingapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user = new User(createUserRequest.getName(),
                createUserRequest.getSurname(),
                createUserRequest.getNumber(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                LocalDateTime.now(),
                true);

        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto getUserById(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = findUserById(id);

        user.setName(updateUserRequest.getName());
        user.setSurname(updateUserRequest.getSurname());
        user.setNumber(updateUserRequest.getNumber());
        user.setPassword(updateUserRequest.getPassword());

        return userDtoConverter.convert(userRepository.save(user));
    }
    public void deleteUser(Long id) {

        findUserById(id);
        userRepository.deleteById(id);
    }

    public User findUserById(Long userId) {

        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found id = " + userId));
    }
}
