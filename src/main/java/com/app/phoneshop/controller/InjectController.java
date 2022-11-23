package com.app.phoneshop.controller;

import com.app.phoneshop.model.Product;
import com.app.phoneshop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class InjectController {
    private final ProductService productService;

    public InjectController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/inject")
    public String inject() {
        Product iProduct8 = new Product();
        iProduct8.setTitle("iPhone8");
        iProduct8.setPrice(new BigDecimal(499));
        productService.save(iProduct8);

        Product iProductX = new Product();
        iProductX.setTitle("iPhoneX");
        iProductX.setPrice(new BigDecimal(699));
        productService.save(iProductX);

        Product iProduct11 = new Product();
        iProduct11.setTitle("iPhone11");
        iProduct11.setPrice(new BigDecimal(499));
        productService.save(iProduct11);

        Product iProduct12 = new Product();
        iProduct12.setTitle("iPhone12");
        iProduct12.setPrice(new BigDecimal(999));
        productService.save(iProduct12);

        Product iProduct13 = new Product();
        iProduct13.setTitle("iPhone13");
        iProduct13.setPrice(new BigDecimal(1299));
        productService.save(iProduct13);

        return "Successfully injected!";
    }
}
