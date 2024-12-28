package com.example.springsecurity6withjwt.mapper;

import com.example.springsecurity6withjwt.dto.MessageDto;
import com.example.springsecurity6withjwt.entity.Messages;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Messages toMessage(MessageDto messageDto);
    MessageDto toMessageDto(Messages messages);
}
