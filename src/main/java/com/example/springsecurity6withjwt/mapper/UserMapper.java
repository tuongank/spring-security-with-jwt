package com.example.springsecurity6withjwt.mapper;

import com.example.springsecurity6withjwt.dto.UserDto;
import com.example.springsecurity6withjwt.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
}
