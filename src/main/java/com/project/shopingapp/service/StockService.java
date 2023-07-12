package com.project.shopingapp.service;

import com.project.shopingapp.dto.StockDto;
import com.project.shopingapp.dto.StockDtoConverter;
import com.project.shopingapp.dto.request.CreateStockRequest;
import com.project.shopingapp.dto.request.UpdateStockRequest;
import com.project.shopingapp.model.Product;
import com.project.shopingapp.model.Stock;
import com.project.shopingapp.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final ProductService productService;
    private final StockDtoConverter stockDtoConverter;

    public StockService(StockRepository stockRepository, ProductService productService, StockDtoConverter stockDtoConverter) {

        this.stockRepository = stockRepository;
        this.productService = productService;
        this.stockDtoConverter = stockDtoConverter;
    }

    public StockDto createStock(CreateStockRequest createStockRequest) {
        Product product = productService.findProductById(createStockRequest.getProductId());

        Stock stock = new Stock(createStockRequest.getId(),
                product,
                createStockRequest.getCount(),
                createStockRequest.getStore());

        return stockDtoConverter.convert(stockRepository.save(stock));

    }

    public StockDto getStockByProductId(Long productId) {
        return stockDtoConverter.convert(stockRepository.findByProductId(productId));
    }

    public StockDto updateStockById(Long id, UpdateStockRequest updateStockRequest) {
        Stock stock = stockRepository.findById(id).orElse(null);

        stock.setCount(updateStockRequest.getCount());
        stock.setStore(updateStockRequest.getStore());

        return stockDtoConverter.convert(stockRepository.save(stock));

    }
}
