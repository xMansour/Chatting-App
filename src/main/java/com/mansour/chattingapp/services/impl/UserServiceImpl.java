package com.mansour.chattingapp.services.impl;

import com.mansour.chattingapp.dtos.UserRequestDto;
import com.mansour.chattingapp.dtos.UserResponseDto;
import com.mansour.chattingapp.entities.User;
import com.mansour.chattingapp.mappers.UserEntityToUserResponseDtoMapper;
import com.mansour.chattingapp.mappers.UserRequestDtoToUserEntityMapper;
import com.mansour.chattingapp.repositories.UserRepository;
import com.mansour.chattingapp.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRequestDtoToUserEntityMapper userRequestDtoToUserEntityMapper;
    private final UserEntityToUserResponseDtoMapper userEntityToUserResponseDtoMapper;

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        log.info("UserServiceImpl#create userRequestDto = {}", userRequestDto);
        User createdUser = userRepository.save(userRequestDtoToUserEntityMapper.apply(userRequestDto));
        return userEntityToUserResponseDtoMapper.apply(createdUser);
    }

    @Override
    public UserResponseDto update(UUID userId, UserRequestDto userRequestDto) {
        log.info("UserServiceImpl#update userRequestDto = {}", userRequestDto);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));//TODO:: add custom exception
        User updatedUser = userRepository.save(userRequestDtoToUserEntityMapper.updateEntity(user, userRequestDto));
        return userEntityToUserResponseDtoMapper.apply(updatedUser);
    }

    @Override
    public void delete(UUID userId) {
        log.info("UserServiceImpl#delete userId = {}", userId);
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponseDto get(UUID userId) {
        log.info("UserServiceImpl#get userId = {}", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));//TODO:: add custom exception
        return userEntityToUserResponseDtoMapper.apply(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        log.info("UserServiceImpl#getAll");
        return userRepository.findAll().stream().map(userEntityToUserResponseDtoMapper).toList();
    }
}
