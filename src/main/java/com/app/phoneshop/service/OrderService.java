package com.app.phoneshop.service;

import com.app.phoneshop.model.Order;
import com.app.phoneshop.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface OrderService {
    Order completeOrder(Order order);

    void removeOrder(Long id);

    List<Order> getOrdersHistory(User user);

}
