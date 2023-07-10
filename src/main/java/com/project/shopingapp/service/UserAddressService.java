package com.project.shopingapp.service;

import com.project.shopingapp.dto.UserAddressDto;
import com.project.shopingapp.dto.UserAddressDtoConverter;
import com.project.shopingapp.dto.request.CreateUserAddressRequest;
import com.project.shopingapp.dto.request.UpdateUserAddressRequest;
import com.project.shopingapp.model.User;
import com.project.shopingapp.model.UserAddress;
import com.project.shopingapp.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAddressService {
    private final UserAddressRepository userAddressRepository;
    private final UserService userService;
    private final UserAddressDtoConverter userAddressDtoConverter;

    public UserAddressService(UserAddressRepository userAddressRepository, UserService userService,
                              UserAddressDtoConverter userAddressDtoConverter) {
        this.userAddressRepository = userAddressRepository;
        this.userService = userService;
        this.userAddressDtoConverter = userAddressDtoConverter;
    }

    public UserAddressDto createUserAddress(CreateUserAddressRequest createUserAddressRequest) {
        User user = userService.findUserById(createUserAddressRequest.getUserId());
        UserAddress userAddress = new UserAddress(createUserAddressRequest.getId(),
                user,
                createUserAddressRequest.getAddressText(),
                createUserAddressRequest.getCity(),
                createUserAddressRequest.getDistrict());

        return userAddressDtoConverter.converter(userAddressRepository.save(userAddress));
    }

    public UserAddressDto updateUserAddress(Long id, UpdateUserAddressRequest updateUserAddressRequest) {
        UserAddress userAddress = userAddressRepository.findById(id).orElse(null);

        userAddress.setAddressText(updateUserAddressRequest.getAddressText());
        userAddress.setCity(updateUserAddressRequest.getCity());
        userAddress.setDistrict(updateUserAddressRequest.getDistrict());

        return userAddressDtoConverter.converter(userAddressRepository.save(userAddress));
    }

    public UserAddressDto getUserAddressById(Long id) {

        return userAddressDtoConverter.converter(userAddressRepository.findById(id).orElse(null));
    }

    public void deleteUserAddressById(Long id) {

        userAddressRepository.deleteById(id);
    }

    public List<UserAddressDto> getAllUserAddress(Optional<Long> userId) {
        List<UserAddress> userAddressList;
        if (userId.isPresent()){
            userAddressList = userAddressRepository.findByUserId(userId);
        }
        else
            userAddressList = userAddressRepository.findAll();

        return userAddressList.stream().map(userAddressDtoConverter::converter).collect(Collectors.toList());
    }
}
