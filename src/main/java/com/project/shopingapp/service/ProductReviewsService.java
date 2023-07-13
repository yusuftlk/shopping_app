package com.project.shopingapp.service;

import com.project.shopingapp.dto.ProductReviewsDto;
import com.project.shopingapp.dto.ProductReviewsDtoConverter;
import com.project.shopingapp.dto.request.CreateProductReviewRequest;
import com.project.shopingapp.dto.request.UpdateProductReviewRequest;
import com.project.shopingapp.model.Product;
import com.project.shopingapp.model.ProductReviews;
import com.project.shopingapp.model.User;
import com.project.shopingapp.repository.ProductReviewsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductReviewsService {
    private final ProductReviewsRepository productReviewsRepository;
    private final ProductService productService;
    private final UserService userService;
    private final ProductReviewsDtoConverter productReviewsDtoConverter;


    public ProductReviewsService(ProductReviewsRepository productReviewsRepository, ProductService productService, UserService userService, ProductReviewsDtoConverter productReviewsDtoConverter) {
        this.productReviewsRepository = productReviewsRepository;
        this.productService = productService;
        this.userService = userService;
        this.productReviewsDtoConverter = productReviewsDtoConverter;
    }

    public ProductReviewsDto createProductReview(CreateProductReviewRequest createProductReviewRequest) {
        Product product = productService.findProductById(createProductReviewRequest.getProductId());
        User user = userService.findUserById(createProductReviewRequest.getUserId());

        ProductReviews productReviews = new ProductReviews(null,
                product,
                user,
                createProductReviewRequest.getReview(),
                LocalDateTime.now(),
                true);
        return productReviewsDtoConverter.convert(productReviewsRepository.save(productReviews));
    }

    public List<ProductReviewsDto> getProductReviewsByProductId(Long productId) {

        List<ProductReviews> productReviewsList = productReviewsRepository.findByProductId(productId);

        return productReviewsList.stream().map(productReviewsDtoConverter::convert)
                .collect(Collectors.toList());

    }

    public ProductReviewsDto updateProductReviewById(Long id, UpdateProductReviewRequest updateProductReviewRequest) {

        ProductReviews productReviews = productReviewsRepository.findById(id).orElse(null);
        productReviews.setReview(updateProductReviewRequest.getReview());

        return productReviewsDtoConverter.convert(productReviewsRepository.save(productReviews));

    }

    public void deleteProductReviewById(Long id) {

        productReviewsRepository.deleteById(id);
    }
}
