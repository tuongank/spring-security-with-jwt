package com.example.springsecurity6withjwt.config;

import com.example.springsecurity6withjwt.entity.User;
import com.example.springsecurity6withjwt.enums.EROLE;
import com.example.springsecurity6withjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationInit implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    @Override
    public void run(ApplicationArguments args) {
        {
            EROLE role = EROLE.ADMIN;

            if (userRepository.findByUsername(username).isEmpty()) {
                User user = User.builder()
                        .username(username)
                        .password(passwordEncoder.encode(password))
                        .address("Ha Noi")
                        .role(role)
                        .build();
                userRepository.save(user);
                log.info("Admin account created");
            }
        }
    }
}
