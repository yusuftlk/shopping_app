package com.project.shopingapp.dto;

import com.project.shopingapp.model.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockDtoConverter {
    private final ProductDtoConverter productDtoConverter;

    public StockDtoConverter(ProductDtoConverter productDtoConverter) {
        this.productDtoConverter = productDtoConverter;
    }

    public StockDto convert(Stock from){
        return new StockDto(from.getId(),
                productDtoConverter.convert(from.getProduct()),
                from.getCount(),
                from.getStore());
    }
}
