package com.app.phoneshop.service.impl;

import com.app.phoneshop.model.Product;
import com.app.phoneshop.model.ShoppingCart;
import com.app.phoneshop.model.User;
import com.app.phoneshop.repository.ProductRepository;
import com.app.phoneshop.repository.ShoppingCartRepository;
import com.app.phoneshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ProductRepository productRepository, ShoppingCartRepository shoppingCartRepository) {
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public void addProduct(Product inputProduct, User user) {
        Product product = new Product();
        product.setTitle(inputProduct.getTitle());
        product.setPrice(inputProduct.getPrice());
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user);
        productRepository.save(product);
        shoppingCart.getProducts().add(product);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.getShoppingCartByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setProducts(null);
        shoppingCartRepository.save(shoppingCart);
    }
}
