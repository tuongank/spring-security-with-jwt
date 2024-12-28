package com.example.springsecurity6withjwt.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ConversationDto {
    private Long id;
    private Long user1Id;
    private Long user2Id;
    private Timestamp lastMessage;
}
