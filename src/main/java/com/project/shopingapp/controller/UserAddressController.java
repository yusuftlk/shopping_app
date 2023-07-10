package com.project.shopingapp.controller;

import com.project.shopingapp.dto.ProductDto;
import com.project.shopingapp.dto.UserAddressDto;
import com.project.shopingapp.dto.request.CreateUserAddressRequest;
import com.project.shopingapp.dto.request.UpdateUserAddressRequest;
import com.project.shopingapp.model.UserAddress;
import com.project.shopingapp.service.UserAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/useraddress")
public class UserAddressController {
    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }
    @PostMapping
    public ResponseEntity<UserAddressDto> createUserAddress(@RequestBody CreateUserAddressRequest createUserAddressRequest){
        return ResponseEntity.ok(userAddressService.createUserAddress(createUserAddressRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserAddressDto> updateUserAddress(@RequestBody UpdateUserAddressRequest updateUserAddressRequest, @PathVariable Long id){
        return ResponseEntity.ok(userAddressService.updateUserAddress(id, updateUserAddressRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserAddressDto> getUserAddressById(@PathVariable Long id){
        return ResponseEntity.ok(userAddressService.getUserAddressById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteUserAddressById(@PathVariable Long id)
    {
        userAddressService.deleteUserAddressById(id);
    }
    @GetMapping
    public ResponseEntity<List<UserAddressDto>> getAllUserAddress(@RequestParam Optional<Long> userId){
        return ResponseEntity.ok(userAddressService.getAllUserAddress(userId));
    }
}
