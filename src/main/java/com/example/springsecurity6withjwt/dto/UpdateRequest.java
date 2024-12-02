package com.example.springsecurity6withjwt.dto;

import lombok.Data;

@Data
public class UpdateRequest {
    private String password;
    private String address;
}
