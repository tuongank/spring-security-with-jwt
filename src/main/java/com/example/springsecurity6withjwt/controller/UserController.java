package com.example.springsecurity6withjwt.controller;

import com.example.springsecurity6withjwt.dto.ApiResponse;
import com.example.springsecurity6withjwt.dto.LoginRequest;
import com.example.springsecurity6withjwt.dto.RegisterRequest;
import com.example.springsecurity6withjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/log-in")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.register(registerRequest));
    }
}
