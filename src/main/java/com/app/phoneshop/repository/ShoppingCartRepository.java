package com.app.phoneshop.repository;

import com.app.phoneshop.model.ShoppingCart;
import com.app.phoneshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart getShoppingCartByUser(User user);
}
