package com.app.phoneshop.dto.mapper;

import com.app.phoneshop.dto.shoppingCart.ShoppingCartResponseDto;
import com.app.phoneshop.model.Product;
import com.app.phoneshop.model.ShoppingCart;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper implements
        ResponseMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setProductIds(shoppingCart.getProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
