package com.project.shopingapp.repository;

import com.project.shopingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Optional<Long> categoryId);

    List<Product> findByCategoryIdAndProductCode(Optional<Long> categoryId, Optional<String> productCode);

    List<Product> findByProductCode(Optional<String> productCode);

    List<Product> findByCategoryIdAndName(Optional<Long> categoryId, Optional<String> productName);

    List<Product> findByName(Optional<String> productName);
}
