package com.app.phoneshop.service.impl;

import com.app.phoneshop.model.Order;
import com.app.phoneshop.model.User;
import com.app.phoneshop.repository.OrderRepository;
import com.app.phoneshop.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order completeOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }


    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderRepository.getOrdersByUser(user);
    }
}
