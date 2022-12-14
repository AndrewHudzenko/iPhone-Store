package com.app.phoneshop.dto.mapper;

import com.app.phoneshop.dto.order.OrderResponseDto;
import com.app.phoneshop.model.Order;
import com.app.phoneshop.model.Product;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements ResponseMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setProductsIds(order.getProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setPaid(order.isPaid());
        return responseDto;
    }
}
