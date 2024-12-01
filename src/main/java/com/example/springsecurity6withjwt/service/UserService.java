package com.example.springsecurity6withjwt.service;

import com.example.springsecurity6withjwt.config.JwtUtils;
import com.example.springsecurity6withjwt.dto.ApiResponse;
import com.example.springsecurity6withjwt.dto.LoginRequest;
import com.example.springsecurity6withjwt.dto.RegisterRequest;
import com.example.springsecurity6withjwt.entity.User;
import com.example.springsecurity6withjwt.enums.EROLE;
import com.example.springsecurity6withjwt.mapper.UserMapper;
import com.example.springsecurity6withjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final UserMapper userMapper;

    public ApiResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        String token = jwtUtils.generateToken(user);

        return ApiResponse.builder()
                .code(200)
                .message("Login success")
                .token(token)
                .expireTime("1h")
                .role(user.getRole().name())
                .build();
    }

    public ApiResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        EROLE role = EROLE.USER;
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAddress(request.getAddress());
        user.setRole(role);

        userRepository.save(user);
        return ApiResponse.builder()
                .code(200)
                .message("User registered")
                .role(role.name())
                .user(userMapper.toUserDto(user))
                .build();
    }
}
