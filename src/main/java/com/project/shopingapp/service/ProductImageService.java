package com.project.shopingapp.service;

import com.project.shopingapp.dto.ProductImageDto;
import com.project.shopingapp.dto.ProductImageDtoConverter;
import com.project.shopingapp.dto.request.CreateProductImageRequest;
import com.project.shopingapp.model.Product;
import com.project.shopingapp.model.ProductImage;
import com.project.shopingapp.repository.ProductImageRepository;
import com.project.shopingapp.utils.ImageUpload;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ProductImageService {
    private final ProductImageRepository productImageRepository;
    private final ProductService productService;
    private final ImageUpload imageUpload;

    public ProductImageService(ProductImageRepository productImageRepository, ProductService productService, ImageUpload imageUpload) {
        this.productImageRepository = productImageRepository;
        this.productService = productService;
        this.imageUpload = imageUpload;
    }

    public ProductImageDto uploadImage(MultipartFile image, Long productId){

        ProductImage productImage = new ProductImage();
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        if (fileName.contains(".."))
            System.out.println("not a valid file");
        try {

            productImage.setImage(Base64.getEncoder().encodeToString(image.getBytes()));

        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Product product = productService.findProductById(productId);
        productImage.setProduct(product);
        return ProductImageDtoConverter.convertStatic(productImageRepository.save(productImage));
    }
}
