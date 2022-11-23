package com.app.phoneshop.dto.order;

import com.app.phoneshop.model.Product;
import com.app.phoneshop.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private List<Product> products;
    private LocalDateTime orderTime;
    private User user;
    private boolean isPaid;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
