package com.project.shopingapp.controller;

import com.project.shopingapp.service.ProductReviewsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productreviews")
public class ProductReviewsController {
    private final ProductReviewsService productReviewsService;

    public ProductReviewsController(ProductReviewsService productReviewsService) {
        this.productReviewsService = productReviewsService;
    }
}
