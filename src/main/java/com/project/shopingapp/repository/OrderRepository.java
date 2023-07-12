package com.project.shopingapp.repository;

import com.project.shopingapp.dto.OrderDto;
import com.project.shopingapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Optional<Long> userId);
}
