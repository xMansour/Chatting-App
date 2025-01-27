package com.mansour.chattingapp.services;

import com.mansour.chattingapp.dtos.UserRequestDto;
import com.mansour.chattingapp.dtos.UserResponseDto;

import java.util.UUID;

public interface UserService extends BaseService<UserRequestDto, UserResponseDto, UUID> {
}
