package com.example.springsecurity6withjwt.service;

import com.example.springsecurity6withjwt.dto.ApiResponse;
import com.example.springsecurity6withjwt.dto.ConversationDto;
import com.example.springsecurity6withjwt.dto.MessageDto;
import com.example.springsecurity6withjwt.entity.Conversation;
import com.example.springsecurity6withjwt.entity.Messages;
import com.example.springsecurity6withjwt.mapper.ConversationMapper;
import com.example.springsecurity6withjwt.mapper.MessageMapper;
import com.example.springsecurity6withjwt.repository.ConversationRepository;
import com.example.springsecurity6withjwt.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final ConversationMapper conversationMapper;

    public ApiResponse saveMessage(MessageDto messageDto) {
        Conversation conversation = conversationRepository
                .findByUser1IdAndUser2Id(messageDto.getSenderId(), messageDto.getReceiverId());

        if (conversation == null) {
            conversation = new Conversation();

            conversation.setUser1Id(messageDto.getSenderId());
            conversation.setUser2Id(messageDto.getReceiverId());
        }

        conversation.setLastMessage(new Timestamp(System.currentTimeMillis()));
        conversationRepository.save(conversation);

        Messages messages = messageMapper.toMessage(messageDto);
        Messages savedMes = messageRepository.save(messages);
        MessageDto messageDto1 = messageMapper.toMessageDto(savedMes);

        return ApiResponse.builder()
                .code(200)
                .message("Success")
                .messages(messageDto1)
                .build();
    }

    public ApiResponse getConversations(Long userId) {
        List<Conversation> conversationsList = conversationRepository
                .findByUser1IdOrUser2Id(userId, userId);

        List<ConversationDto> conversationDto = conversationsList
                .stream()
                .map(conversationMapper::toConversationDto)
                .toList();

        return ApiResponse.builder()
                .code(200)
                .message("Success")
                .listConversation(conversationDto)
                .build();
    }
}
