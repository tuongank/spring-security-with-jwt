package com.example.springsecurity6withjwt.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String address;
}
