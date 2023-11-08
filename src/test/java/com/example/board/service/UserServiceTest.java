package com.example.board.service;

import com.example.board.dto.SignupRequestDto;
import com.example.board.persist.User;
import com.example.board.persist.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("회원가입 완료 - 이메일인증 전")
    void signup() {
        SignupRequestDto mockedDto = mock(SignupRequestDto.class);
        User mockedUser = mock(User.class);
        when(userRepository.persist(any(User.class))).thenReturn(mockedUser);

        userService.signup(mockedDto);

        verify(userRepository).persist(any(User.class));
    }

    @Test
    @DisplayName("이메일 중복 체크")
    void existsEmail() {
        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        userService.existsEmail("email");

        verify(userRepository).existsByEmail(anyString());
    }

}