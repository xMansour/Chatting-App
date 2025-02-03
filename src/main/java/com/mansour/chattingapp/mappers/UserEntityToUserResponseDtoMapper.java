package com.mansour.chattingapp.mappers;

import com.mansour.chattingapp.dtos.UserResponseDto;
import com.mansour.chattingapp.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
public class UserEntityToUserResponseDtoMapper implements Function<User, UserResponseDto> {
    @Override
    public UserResponseDto apply(User user) {
        log.info("UserEntityToUserResponseDtoMapper#apply user = {}", user);
        return UserResponseDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
