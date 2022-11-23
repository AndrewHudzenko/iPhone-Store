package com.app.phoneshop.dto.mapper;

import com.app.phoneshop.dto.order.OrderRequestDto;
import com.app.phoneshop.dto.order.OrderResponseDto;
import com.app.phoneshop.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ResponseMapper<OrderResponseDto, Order>,
        RequestMapper<OrderRequestDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setProducts(order.getProducts());
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setPaid(order.isPaid());
        return responseDto;
    }

    @Override
    public Order toModel(OrderRequestDto requestDto) {
        Order order = new Order();
        order.setProducts(requestDto.getProducts());
        order.setOrderTime(requestDto.getOrderTime());
        order.setUser(requestDto.getUser());
        order.setPaid(requestDto.isPaid());
        return order;
    }
}
