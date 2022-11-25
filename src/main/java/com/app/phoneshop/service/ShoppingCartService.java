package com.app.phoneshop.service;

import com.app.phoneshop.model.Product;
import com.app.phoneshop.model.ShoppingCart;
import com.app.phoneshop.model.User;

public interface ShoppingCartService {
    void addProduct(Product product, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
