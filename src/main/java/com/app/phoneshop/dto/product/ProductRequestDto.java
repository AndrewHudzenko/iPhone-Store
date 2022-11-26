package com.app.phoneshop.dto.product;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductRequestDto {
    @NotNull
    private String title;
    @NotNull
    private BigDecimal price;

    public ProductRequestDto(String title, BigDecimal price) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
