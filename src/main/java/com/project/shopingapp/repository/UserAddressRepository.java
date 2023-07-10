package com.project.shopingapp.repository;

import com.project.shopingapp.dto.UserAddressDto;
import com.project.shopingapp.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    List<UserAddress> findByUserId(Optional<Long> userId);
}
