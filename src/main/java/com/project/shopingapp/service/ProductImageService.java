package com.project.shopingapp.service;

import com.project.shopingapp.repository.ProductImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
    private final ProductImageRepository productImageRepository;

    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }
}
