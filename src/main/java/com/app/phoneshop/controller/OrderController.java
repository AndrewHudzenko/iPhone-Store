package com.app.phoneshop.controller;

import com.app.phoneshop.dto.mapper.OrderMapper;
import com.app.phoneshop.dto.mapper.ResponseMapper;
import com.app.phoneshop.dto.order.OrderResponseDto;
import com.app.phoneshop.model.Order;
import com.app.phoneshop.model.ShoppingCart;
import com.app.phoneshop.model.User;
import com.app.phoneshop.service.OrderService;
import com.app.phoneshop.service.ShoppingCartService;
import com.app.phoneshop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final ResponseMapper<OrderResponseDto, Order> responseMapper;

    public OrderController(UserService userService, OrderMapper orderMapper, OrderService orderService, ShoppingCartService shoppingCartService, ResponseMapper<OrderResponseDto, Order> responseMapper) {
        this.userService = userService;
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        ShoppingCart cart = shoppingCartService.getByUser(user);
        return orderMapper.toDto(orderService.completeOrder(cart));
    }

    @DeleteMapping("{/id}")
    public void delete(@PathVariable Long id) {
        orderService.removeOrder(id);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return orderService.getOrdersHistory(user)
                .stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
