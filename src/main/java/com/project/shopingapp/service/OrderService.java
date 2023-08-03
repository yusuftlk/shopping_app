package com.project.shopingapp.service;

import com.project.shopingapp.dto.OrderDto;
import com.project.shopingapp.dto.OrderDtoConverter;
import com.project.shopingapp.dto.request.CreateOrderRequest;
import com.project.shopingapp.dto.request.UpdateOrderRequest;
import com.project.shopingapp.exception.OrderNotFoundException;
import com.project.shopingapp.model.Order;
import com.project.shopingapp.model.Product;
import com.project.shopingapp.model.User;
import com.project.shopingapp.model.UserAddress;
import com.project.shopingapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;
    private final UserAddressService userAddressService;
    private final OrderDtoConverter orderDtoConverter;

    public OrderService(OrderRepository orderRepository, UserService userService, ProductService productService, UserAddressService userAddressService, OrderDtoConverter orderDtoConverter) {

        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
        this.userAddressService = userAddressService;
        this.orderDtoConverter = orderDtoConverter;
    }

    public OrderDto createOrder(CreateOrderRequest createOrderRequest) {
        User user = userService.findUserById(createOrderRequest.getUserId());
        Product product = productService.findProductById(createOrderRequest.getProductId());
        UserAddress userAddress = userAddressService.findUserAddressById(createOrderRequest.getUserAddressId());

        System.out.println(user.getName());
        System.out.println(product.getName());
        System.out.println(userAddress.getAddressText());

        Order order = new Order(null,
                user,
                userAddress,
                product,
                createOrderRequest.getInformation(),
                LocalDateTime.now(),
                true);
        return orderDtoConverter.convert(orderRepository.save(order));
    }

    public OrderDto getOrderById(Long id) {
        return orderDtoConverter.convert(findOrderById(id));
    }

    public List<OrderDto> getOrdersByUserId(Optional<Long> userId) {
        if (userId.isPresent()){

            List<Order> orderList = orderRepository.findByUserId(userId);
            return orderDtoConverter.convert(orderList);
        }
        else return null;
    }

    public OrderDto updateOrder(Long id, UpdateOrderRequest updateOrderRequest) {
        Order order = findOrderById(id);
        UserAddress userAddress = userAddressService.findUserAddressById(updateOrderRequest.getUserAddressId());
        order.setInformation(updateOrderRequest.getInformation());
        order.setUserAddress(userAddress);

        return orderDtoConverter.convert(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    protected Order findOrderById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException("Order Not Found id = " + id));
        return order;
    }
}
