package com.app.phoneshop.service;

import com.app.phoneshop.model.User;
import java.util.Optional;

public interface UserService {
    User save(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
