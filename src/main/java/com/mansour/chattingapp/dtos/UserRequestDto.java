package com.mansour.chattingapp.dtos;

import lombok.Data;

@Data
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
