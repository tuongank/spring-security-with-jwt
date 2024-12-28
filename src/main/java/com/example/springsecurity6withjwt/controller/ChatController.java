package com.example.springsecurity6withjwt.controller;

import com.example.springsecurity6withjwt.dto.ApiResponse;
import com.example.springsecurity6withjwt.dto.MessageDto;
import com.example.springsecurity6withjwt.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<ApiResponse> saveMes(@RequestBody MessageDto messageDto) {
        return ResponseEntity.ok(messageService.saveMessage(messageDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getMes(@PathVariable Long userId) {
        return ResponseEntity.ok(messageService.getConversations(userId));
    }
}
