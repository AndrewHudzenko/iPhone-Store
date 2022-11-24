package com.app.phoneshop.controller;

import javax.validation.Valid;
import com.app.phoneshop.dto.mapper.ResponseMapper;
import com.app.phoneshop.dto.user.UserRequestDto;
import com.app.phoneshop.dto.user.UserResponseDto;
import com.app.phoneshop.model.User;
import com.app.phoneshop.service.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService authService,
                                    ResponseMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.authService = authService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @GetMapping("/")
    public String hello(Authentication authentication) {
        return String.format("Hello, %s!", authentication.getName());
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userDtoResponseMapper.toDto(user);
    }
}