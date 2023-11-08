package com.example.board.service;

import com.example.board.dto.SignupRequestDto;
import com.example.board.persist.User;
import com.example.board.persist.repository.UserRepository;
import com.example.board.type.ProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequestDto dto) {
        User newUser = userRepository.persist(
                User.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .phone(dto.getPhone())
                        .nickname(dto.getPhone())
                        .phoneAuthYN(true)
                        .provider(ProviderType.OWN)
                        .build());
    }

    public boolean existsEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
