package com.mansour.chattingapp.mappers;

import com.mansour.chattingapp.dtos.UserRequestDto;
import com.mansour.chattingapp.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRequestDtoToUserEntityMapper implements Function<UserRequestDto, User> {
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User apply(UserRequestDto userRequestDto) {
        log.info("UserRequestDtoToEntityMapper#apply userRequestDto = {}", userRequestDto);
        return User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .build();
    }

    public User updateEntity(User user, UserRequestDto userRequestDto) {
        log.info("UserRequestDtoToEntityMapper#updateEntity userRequestDto = {}", userRequestDto);
        if (userRequestDto.getFirstName() != null) user.setFirstName(userRequestDto.getFirstName());
        if (userRequestDto.getLastName() != null) user.setLastName(userRequestDto.getLastName());
        if (userRequestDto.getEmail() != null) user.setEmail(userRequestDto.getEmail());
        if (userRequestDto.getPassword() != null) user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        return user;
    }
}
