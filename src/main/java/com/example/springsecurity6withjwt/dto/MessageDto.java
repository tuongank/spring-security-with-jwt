package com.example.springsecurity6withjwt.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageDto {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String message;
    private Timestamp timestamp;
}
