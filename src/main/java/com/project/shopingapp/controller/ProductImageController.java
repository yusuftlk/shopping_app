package com.project.shopingapp.controller;

import com.project.shopingapp.dto.ProductImageDto;
import com.project.shopingapp.dto.request.CreateProductImageRequest;
import com.project.shopingapp.model.ProductImage;
import com.project.shopingapp.service.ProductImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/productimages")
public class ProductImageController {
    private final ProductImageService productImageService;

    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }
    @PostMapping
    public ResponseEntity<ProductImageDto> addImage(@RequestParam("productId") Long productId,
                                                    @RequestParam("imageProduct") MultipartFile imageProduct){
        return ResponseEntity.ok(productImageService.uploadImage(imageProduct, productId));
    }
}
