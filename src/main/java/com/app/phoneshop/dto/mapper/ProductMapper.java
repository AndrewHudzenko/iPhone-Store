package com.app.phoneshop.dto.mapper;

import com.app.phoneshop.dto.product.ProductRequestDto;
import com.app.phoneshop.dto.product.ProductResponseDto;
import com.app.phoneshop.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements RequestMapper<ProductRequestDto, Product>,
        ResponseMapper<ProductResponseDto, Product> {
    public ProductResponseDto toDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        return responseDto;
    }

    public Product toModel(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setTitle(requestDto.getTitle());
        product.setPrice(requestDto.getPrice());
        return product;
    }
}
