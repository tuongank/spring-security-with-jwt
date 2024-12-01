package com.example.springsecurity6withjwt.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String address;
}
