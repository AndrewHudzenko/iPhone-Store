package com.app.phoneshop.service;

import com.app.phoneshop.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
