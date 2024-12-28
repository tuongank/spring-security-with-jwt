package com.example.springsecurity6withjwt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private int code;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();

    private String token;
    private String role;
    private String expireTime;

    private UserDto user;
    private List<UserDto> userList;

    private MessageDto messages;
    private List<MessageDto> listMessage;

    private ConversationDto conversation;
    private List<ConversationDto> listConversation;
}
