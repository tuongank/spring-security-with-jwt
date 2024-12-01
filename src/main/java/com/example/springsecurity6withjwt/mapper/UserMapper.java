package com.example.springsecurity6withjwt.mapper;

import com.example.springsecurity6withjwt.dto.UserDto;
import com.example.springsecurity6withjwt.entity.User;
import com.example.springsecurity6withjwt.enums.EROLE;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
}
