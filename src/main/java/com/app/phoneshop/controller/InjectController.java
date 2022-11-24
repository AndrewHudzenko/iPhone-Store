package com.app.phoneshop.controller;

import com.app.phoneshop.model.Product;
import com.app.phoneshop.model.Role;
import com.app.phoneshop.model.User;
import com.app.phoneshop.service.ProductService;
import com.app.phoneshop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final ProductService productService;
    private final UserService userService;

    public InjectController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
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

        Role manager = new Role();
        manager.setRoleName(Role.RoleName.MANAGER);
        Role client = new Role();
        client.setRoleName(Role.RoleName.CLIENT);

        User bob = new User();
        bob.setEmail("bob@i.ua");
        bob.setPassword("1234");
        bob.setRole(Set.of(manager));

        User alice = new User();
        alice.setEmail("alice@i.ua");
        alice.setPassword("1234");
        alice.setRole(Set.of(client));

        userService.save(bob);
        userService.save(alice);

        return "Successfully injected!";
    }
}
