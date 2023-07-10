package com.project.shopingapp.service;

import com.project.shopingapp.repository.ProductReviewsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewsService {
    private final ProductReviewsRepository productReviewsRepository;

    public ProductReviewsService(ProductReviewsRepository productReviewsRepository) {
        this.productReviewsRepository = productReviewsRepository;
    }
}
