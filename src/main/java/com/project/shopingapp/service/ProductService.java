package com.project.shopingapp.service;

import com.project.shopingapp.dto.ProductDto;
import com.project.shopingapp.dto.ProductDtoConverter;
import com.project.shopingapp.dto.request.CreateProductRequest;
import com.project.shopingapp.dto.request.UpdateProductRequest;
import com.project.shopingapp.exception.ProductNotFoundException;
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

    public List<ProductDto> getAllProducts(Optional<String> categoryName) {
        List<Product> productList;

        if (categoryName.isPresent())
            productList = productRepository.findByCategoryName(categoryName);
        else
            productList = productRepository.findAll();

        System.out.println();
        return productDtoConverter.convert(productList);
    }
    public ProductDto getProductById(Long id) {

        return productDtoConverter.convert(findProductById(id));
    }

    protected Product findProductById(Long id){

        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found id = " + id));
    }

    public ProductDto createProduct(CreateProductRequest createProductRequest) {
        Category category = categoryService.findCategoryById(createProductRequest.getCategoryId());

        Product product = new Product(
                category,
                createProductRequest.getProductCode(),
                createProductRequest.getName(),
                createProductRequest.getPrice(),
                createProductRequest.getDescription(),
                LocalDateTime.now(),
                true, createProductRequest.getStock());

        return productDtoConverter.convert(productRepository.save(product));
    }

    public ProductDto updateProductById(Long id, UpdateProductRequest updateProductRequest) {
        Product product = findProductById(id);
        Category category = categoryService.findCategoryById(updateProductRequest.getCategoryId());

        product.setCategory(category);
        product.setProductCode(updateProductRequest.getProductCode());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        product.setDescription(updateProductRequest.getDescription());

        return productDtoConverter.convert(productRepository.save(product));

    }
    public void deleteProductById(Long id) {

        findProductById(id);
        productRepository.deleteById(id);
    }
}
