package com.project.shopingapp.repository;

import com.project.shopingapp.model.ProductReviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewsRepository extends JpaRepository<ProductReviews, Long> {
}
