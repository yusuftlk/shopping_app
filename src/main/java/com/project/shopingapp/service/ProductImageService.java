package com.project.shopingapp.service;

import com.project.shopingapp.dto.ImageUtil;
import com.project.shopingapp.dto.request.CreateProductImageRequest;
import com.project.shopingapp.model.Product;
import com.project.shopingapp.model.ProductImage;
import com.project.shopingapp.repository.ProductImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProductImageService {
    private final ProductImageRepository productImageRepository;
    private final ProductService productService;

    public ProductImageService(ProductImageRepository productImageRepository, ProductService productService) {
        this.productImageRepository = productImageRepository;
        this.productService = productService;
    }
}
