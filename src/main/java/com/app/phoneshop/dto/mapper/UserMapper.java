package com.app.phoneshop.dto.mapper;

import com.app.phoneshop.dto.user.UserResponseDto;
import com.app.phoneshop.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
