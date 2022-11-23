package com.app.phoneshop.service.impl;

import com.app.phoneshop.model.User;
import com.app.phoneshop.repository.UserRepository;
import com.app.phoneshop.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }
}
