package com.app.phoneshop.service.impl;

import com.app.phoneshop.repository.OrderRepository;
import com.app.phoneshop.service.OrderPaidService;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class OrderPaidServiceImpl implements OrderPaidService {
    private final OrderRepository orderRepository;
    private final OrderServiceImpl orderService;

    public OrderPaidServiceImpl(OrderRepository orderRepository, OrderServiceImpl orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public void removeUnpaidOrders() {
        orderRepository.findAll()
                .stream()
                .filter(order -> (int) Duration.between(order.getOrderTime(),
                        LocalDateTime.now()).toMinutes() >= 10 && !order.isPaid())
                .forEach(order -> orderService.removeOrder(order.getId()));
    }
}
