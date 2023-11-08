package com.example.board.web;

import com.example.board.dto.SignupRequestDto;
import com.example.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public void signup(SignupRequestDto dto) {
        userService.signup(dto); // 마음에 안듬 서비스 로직의 파라미터를 컨틀롤러(외부) 까지 전파
    }
}
