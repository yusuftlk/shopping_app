package com.project.shopingapp.controller;

import com.project.shopingapp.dto.ProductReviewsDto;
import com.project.shopingapp.dto.request.CreateProductReviewRequest;
import com.project.shopingapp.dto.request.UpdateProductReviewRequest;
import com.project.shopingapp.service.ProductReviewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productreviews")
public class ProductReviewsController {
    private final ProductReviewsService productReviewsService;

    public ProductReviewsController(ProductReviewsService productReviewsService) {
        this.productReviewsService = productReviewsService;
    }

    @PostMapping
    public ResponseEntity<ProductReviewsDto> createProductReview(@RequestBody CreateProductReviewRequest
                                                                             createProductReviewRequest){
        return ResponseEntity.ok(productReviewsService.createProductReview(createProductReviewRequest));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ProductReviewsDto>> getProductReviewsByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(productReviewsService.getProductReviewsByProductId(productId));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductReviewsDto> updateProductReviewById(@RequestBody UpdateProductReviewRequest updateProductReviewRequest, @PathVariable Long id){
        return ResponseEntity.ok(productReviewsService.updateProductReviewById(id,  updateProductReviewRequest));
    }
    @DeleteMapping("/{id}")
    public void deleteProductReviewById(@PathVariable Long id)
    {
        productReviewsService.deleteProductReviewById(id);
    }
}
