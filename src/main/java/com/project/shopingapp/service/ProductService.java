package com.project.shopingapp.service;

import com.project.shopingapp.dto.ProductDto;
import com.project.shopingapp.dto.ProductDtoConverter;
import com.project.shopingapp.dto.request.CreateProductRequest;
import com.project.shopingapp.dto.request.UpdateProductRequest;
import com.project.shopingapp.model.Category;
import com.project.shopingapp.model.Product;
import com.project.shopingapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter, CategoryService categoryService) {

        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
        this.categoryService = categoryService;
    }

    public List<ProductDto> getAllProducts(Optional<Long> categoryId, Optional<String> productCode, Optional<String> productName) {
        List<Product> productList;

        if(categoryId.isPresent() && productCode.isPresent()){
            productList = productRepository.findByCategoryIdAndProductCode(categoryId, productCode);
        }
        else if(categoryId.isPresent() && productName.isPresent()){
            productList = productRepository.findByCategoryIdAndName(categoryId, productName);
        }
        else if(productCode.isPresent()){
            productList = productRepository.findByProductCode(productCode);
        }
        else if(productName.isPresent()){
            productList = productRepository.findByName(productName);
        }
        else if (categoryId.isPresent())
            productList = productRepository.findByCategoryId(categoryId);
        else
            productList = productRepository.findAll();

        return productList.stream().map(productDtoConverter::convert).collect(Collectors.toList());
    }
    public ProductDto getProductById(Long id) {

        return productDtoConverter.convert(productRepository.findById(id).orElse(null));
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public ProductDto createProduct(CreateProductRequest createProductRequest) {
        Category category = categoryService.findCustomerById(createProductRequest.getCategoryId());

        Product product = new Product(createProductRequest.getId(),
                category,
                createProductRequest.getProductCode(),
                createProductRequest.getName(),
                createProductRequest.getPrice(),
                createProductRequest.getDescription(),
                LocalDateTime.now(),
                true);

        return productDtoConverter.convert(productRepository.save(product));
    }

    public ProductDto updateProductById(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id).orElse(null);
        Category category = categoryService.findCustomerById(updateProductRequest.getCategoryId());

        product.setCategory(category);
        product.setProductCode(updateProductRequest.getProductCode());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setDescription(updateProductRequest.getDescription());

        return productDtoConverter.convert(productRepository.save(product));

    }
    public void deleteProductById(Long id) {

        productRepository.deleteById(id);
    }
}
