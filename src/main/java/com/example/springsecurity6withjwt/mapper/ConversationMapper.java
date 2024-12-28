package com.example.springsecurity6withjwt.mapper;

import com.example.springsecurity6withjwt.dto.ConversationDto;
import com.example.springsecurity6withjwt.entity.Conversation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ConversationMapper {
    ConversationDto toConversationDto(Conversation conversation);
    Conversation toConversation(ConversationDto conversationDto);
}
