package com.app.phoneshop.controller;

import com.app.phoneshop.model.Product;
import com.app.phoneshop.service.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.org.hamcrest.Matchers;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldShowAllProducts() {
        List<Product> mockProducts = List.of(
                new Product(41L, "iPhone X", BigDecimal.valueOf(999)),
                new Product(42L, "iPhone 11", BigDecimal.valueOf(1199)),
                new Product(42L, "iPhone 13", BigDecimal.valueOf(1399))
        );
        Mockito.when(productService.findAll()).thenReturn(mockProducts);

        RestAssuredMockMvc.when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("size()", (Matcher<?>) Matchers.equalTo(3))
                .body("[0].id", (Matcher<?>) Matchers.equalTo(41))
                .body("[0].title", (Matcher<?>) Matchers.equalTo("iPhone X"))
                .body("[0].price", (Matcher<?>) Matchers.equalTo(999))
                .body("[1].id", (Matcher<?>) Matchers.equalTo(42))
                .body("[1].title", (Matcher<?>) Matchers.equalTo("iPhone 11"))
                .body("[1].price", (Matcher<?>) Matchers.equalTo(1299))
                .body("[2].id", (Matcher<?>) Matchers.equalTo(43))
                .body("[2].title", (Matcher<?>) Matchers.equalTo("iPhone 13"))
                .body("[2].price", (Matcher<?>) Matchers.equalTo(1399));
    }

}