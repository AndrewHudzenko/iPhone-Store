package com.app.phoneshop.service;

import com.app.phoneshop.model.Order;
import com.app.phoneshop.model.ShoppingCart;
import com.app.phoneshop.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    void removeOrder(Long id);

    List<Order> getOrdersHistory(User user);

    void isOrderPaid(Order order);
}
