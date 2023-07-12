package com.project.shopingapp.controller;

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
    @PostMapping()
    public ProductImage createProductImage(@RequestParam("productImage")MultipartFile file) throws IOException{
        return productImageService.createProductImage(file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getProductImageById(@PathVariable Long id) {
        byte[] image = productImageService.getProductImageById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

}
