package com.mansour.chattingapp.controllers;

import com.mansour.chattingapp.dtos.UserRequestDto;
import com.mansour.chattingapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        userService.create(userRequestDto);
    }

    @PostMapping("/login")
    public void login() {

    }

    @PostMapping("/logout")
    public void logout() {

    }

    @PutMapping("/{userId}")
    public void update(@PathVariable UUID userId, @RequestBody UserRequestDto userRequestDto) {
        userService.update(userId, userRequestDto);
    }
}
