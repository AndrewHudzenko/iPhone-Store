package com.app.phoneshop.repository;

import com.app.phoneshop.model.Order;
import com.app.phoneshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrdersByUser(User user);
}
