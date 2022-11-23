package com.app.phoneshop.service;

import com.app.phoneshop.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product getById(Long id);

    void deleteById(Long id);

    Product update(Product product);

    List<Product> findAll();
}
