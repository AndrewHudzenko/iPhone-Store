package com.app.phoneshop.controller;

import com.app.phoneshop.dto.mapper.ResponseMapper;
import com.app.phoneshop.dto.shoppingCart.ShoppingCartResponseDto;
import com.app.phoneshop.model.Product;
import com.app.phoneshop.model.ShoppingCart;
import com.app.phoneshop.model.User;
import com.app.phoneshop.service.ProductService;
import com.app.phoneshop.service.ShoppingCartService;
import com.app.phoneshop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final UserService userService;
    private final ResponseMapper<ShoppingCartResponseDto, ShoppingCart>
            responseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ProductService productService,
                                  UserService userService,
                                  ResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartResponseDtoMapper) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.userService = userService;
        this.responseMapper = shoppingCartResponseDtoMapper;
    }

    @PutMapping("/products")
    public String addToCart(Authentication auth, @RequestParam Long productId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        Product product = productService.getById(productId);
        shoppingCartService.addProduct(product, user);
        return "Your product was added successfully";
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return responseMapper.toDto(shoppingCartService.getByUser(user));
    }
}
