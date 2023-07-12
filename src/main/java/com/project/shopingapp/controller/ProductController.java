package com.project.shopingapp.controller;

import com.project.shopingapp.dto.ProductDto;
import com.project.shopingapp.dto.request.CreateProductRequest;
import com.project.shopingapp.dto.request.UpdateProductRequest;
import com.project.shopingapp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam Optional<Long> categoryId, @RequestParam Optional<String> productCode, @RequestParam Optional<String> productName){
        return ResponseEntity.ok(productService.getAllProducts(categoryId, productCode, productName));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequest createProductRequest){
        return ResponseEntity.ok(productService.createProduct(createProductRequest));

    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<ProductDto> updateProductById(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest){
        return ResponseEntity.ok(productService.updateProductById(id, updateProductRequest));
    }
    @DeleteMapping
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

}
