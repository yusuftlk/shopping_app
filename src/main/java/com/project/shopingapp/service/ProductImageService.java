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

    public ProductImage createProductImage(MultipartFile file) throws IOException {
        Product product = productService.findProductById(Long.parseLong("1"));

        ProductImage pImage = new ProductImage();
        pImage.setId(Long.parseLong("1"));
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setProduct(product);
        pImage.setImage(ImageUtil.compressImage(file.getBytes()));
        return productImageRepository.save(pImage);
    }

    public byte[] getProductImageById(Long id) {
        Optional<ProductImage> imageData = productImageRepository.findById(id);
        return ImageUtil.decompressImage(imageData.get().getImage());
    }
}
