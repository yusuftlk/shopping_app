package com.project.shopingapp.controller;

import com.project.shopingapp.dto.StockDto;
import com.project.shopingapp.dto.request.CreateStockRequest;
import com.project.shopingapp.dto.request.UpdateStockRequest;
import com.project.shopingapp.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<StockDto> createStock(@RequestBody CreateStockRequest createStockRequest){
        return ResponseEntity.ok(stockService.createStock(createStockRequest));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<StockDto> getStockByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(stockService.getStockByProductId(productId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDto> updateStockById(@PathVariable Long id, @RequestBody UpdateStockRequest updateStockRequest){
        return ResponseEntity.ok(stockService.updateStockById(id, updateStockRequest));
    }
}
