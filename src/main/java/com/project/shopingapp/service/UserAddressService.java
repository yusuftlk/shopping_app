package com.project.shopingapp.service;

import com.project.shopingapp.dto.UserAddressDto;
import com.project.shopingapp.dto.UserAddressDtoConverter;
import com.project.shopingapp.dto.request.CreateUserAddressRequest;
import com.project.shopingapp.dto.request.UpdateUserAddressRequest;
import com.project.shopingapp.exception.UserAddressNotFoundException;
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
        UserAddress userAddress = new UserAddress(null,
                user,
                createUserAddressRequest.getAddressText(),
                createUserAddressRequest.getCity(),
                createUserAddressRequest.getDistrict());

        return userAddressDtoConverter.convert(userAddressRepository.save(userAddress));
    }

    public UserAddressDto updateUserAddress(Long id, UpdateUserAddressRequest updateUserAddressRequest) {
        UserAddress userAddress = findUserAddressById(id);

        userAddress.setAddressText(updateUserAddressRequest.getAddressText());
        userAddress.setCity(updateUserAddressRequest.getCity());
        userAddress.setDistrict(updateUserAddressRequest.getDistrict());

        return userAddressDtoConverter.convert(userAddressRepository.save(userAddress));
    }

    public UserAddressDto getUserAddressById(Long id) {

        return userAddressDtoConverter.convert(findUserAddressById(id));
    }

    public void deleteUserAddressById(Long id) {
        findUserAddressById(id);
        userAddressRepository.deleteById(id);
    }

    public List<UserAddressDto> getAllUserAddress(Optional<Long> userId) {
        List<UserAddress> userAddressList;
        if (userId.isPresent()){
            userAddressList = userAddressRepository.findByUserId(userId);
        }
        else
            userAddressList = userAddressRepository.findAll();

        return userAddressDtoConverter.convert(userAddressList);
    }

    protected UserAddress findUserAddressById(Long id) {
        return userAddressRepository.findById(id).orElseThrow(() -> new UserAddressNotFoundException("User Address Found Found Exception id = " + id));
    }
}
