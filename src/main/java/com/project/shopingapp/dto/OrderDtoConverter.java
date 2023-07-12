package com.project.shopingapp.dto;

import com.project.shopingapp.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoConverter {
    private final UserDtoConverter userDtoConverter;
    private final ProductDtoConverter productDtoConverter;
    private final UserAddressDtoConverter userAddressDtoConverter;

    public OrderDtoConverter(UserDtoConverter userDtoConverter, ProductDtoConverter productDtoConverter,
                             UserAddressDtoConverter userAddressDtoConverter) {
        this.userDtoConverter = userDtoConverter;
        this.productDtoConverter = productDtoConverter;
        this.userAddressDtoConverter = userAddressDtoConverter;
    }

    public OrderDto convert(Order from){
        return new OrderDto(from.getId(),
                userDtoConverter.convert(from.getUser()),
                userAddressDtoConverter.converter(from.getUserAddress()),
                productDtoConverter.convert(from.getProduct()),
                from.getInformation(),
                from.getOrderDate(),
                from.getStatus());
    }
}
