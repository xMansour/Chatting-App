package com.mansour.chattingapp.dtos;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String email;
    private String password;
}
