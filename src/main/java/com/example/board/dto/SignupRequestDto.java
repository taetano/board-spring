package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignupRequestDto {
    private String name;
    private String email;
    private String password;
    private String nickname;
    private String phone;
}
