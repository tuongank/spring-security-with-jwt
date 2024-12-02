package com.example.springsecurity6withjwt.controller;

import com.example.springsecurity6withjwt.dto.ApiResponse;
import com.example.springsecurity6withjwt.dto.UpdateRequest;
import com.example.springsecurity6withjwt.entity.User;
import com.example.springsecurity6withjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> update(@RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.ok(userService.update(updateRequest));
    }

    @GetMapping("/my-info")
    public ResponseEntity<User> myInfo() {
        return ResponseEntity.ok(userService.myInfor());
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
