package com.project.shopingapp.repository;

import com.project.shopingapp.model.ProductReviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReviewsRepository extends JpaRepository<ProductReviews, Long> {
    List<ProductReviews> findByProductId(Long productId);
}
