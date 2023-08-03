package com.project.shopingapp.dto;

import com.project.shopingapp.model.Category;
import com.project.shopingapp.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        return new OrderDto(userDtoConverter.convert(from.getUser()),
                userAddressDtoConverter.convert(from.getUserAddress()),
                productDtoConverter.convert(from.getProduct()),
                from.getInformation(),
                from.getOrderDate());
    }

    public List<OrderDto> convert(List<Order> orderList){
        return orderList.stream().map(this::convert).collect(Collectors.toList());
    }
}
