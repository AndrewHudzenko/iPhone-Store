package com.app.phoneshop.service.impl;

import com.app.phoneshop.PhoneShopApplication;
import com.app.phoneshop.model.Order;
import com.app.phoneshop.model.ShoppingCart;
import com.app.phoneshop.model.User;
import com.app.phoneshop.repository.OrderRepository;
import com.app.phoneshop.service.OrderService;
import com.app.phoneshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderRepository orderRepository, ShoppingCartService shoppingCartService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setProducts(shoppingCart.getProducts());
        order.setOrderTime(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        order.setPaid(false);
        orderRepository.save(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }


    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderRepository.getOrdersByUser(user);
    }

    @Override
    public void isOrderPaid(Order order) {
        Duration duration = Duration.between(order.getOrderTime(), LocalDateTime.now());
        if ((int) duration.toMinutes() >= 10) {
            removeOrder(order.getId());
        }
    }
}
