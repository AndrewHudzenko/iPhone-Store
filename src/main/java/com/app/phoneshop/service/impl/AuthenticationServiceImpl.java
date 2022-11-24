package com.app.phoneshop.service.impl;

import com.app.phoneshop.model.Role;
import com.app.phoneshop.model.User;
import com.app.phoneshop.service.AuthenticationService;
import com.app.phoneshop.service.RoleService;
import com.app.phoneshop.service.ShoppingCartService;
import com.app.phoneshop.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Set.of(roleService.getByName(Role.RoleName.CLIENT)));
        userService.save(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
