package com.example.springsecurity6withjwt.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
