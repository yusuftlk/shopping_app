package com.project.shopingapp.controller;

import com.project.shopingapp.dto.UserDto;
import com.project.shopingapp.dto.request.CreateUserRequest;
import com.project.shopingapp.dto.request.UpdateUserRequest;
import com.project.shopingapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok( userService.getAllUsers());
    }
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest){
        return  ResponseEntity.ok(userService.updateUser(id, updateUserRequest));
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){

        userService.deleteUser(id);
    }
}
