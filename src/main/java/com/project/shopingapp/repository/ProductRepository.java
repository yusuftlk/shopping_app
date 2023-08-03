package com.project.shopingapp.repository;

import com.project.shopingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category = (SELECT c FROM Category c WHERE c.categoryName = ?1)")
    List<Product> findByCategoryName(Optional<String> categoryName);
}
