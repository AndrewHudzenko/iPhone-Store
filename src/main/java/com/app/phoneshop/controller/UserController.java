package com.app.phoneshop.controller;

import com.app.phoneshop.dto.mapper.ResponseMapper;
import com.app.phoneshop.dto.user.UserResponseDto;
import com.app.phoneshop.model.User;
import com.app.phoneshop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ResponseMapper<UserResponseDto, User> responseMapper;

    public UserController(UserService userService,
                          ResponseMapper<UserResponseDto, User> responseMapper) {
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto findByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return responseMapper.toDto(user);
    }
}
