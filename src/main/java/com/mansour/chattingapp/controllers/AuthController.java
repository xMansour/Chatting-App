package com.mansour.chattingapp.controllers;

import com.mansour.chattingapp.dtos.AuthRequestDto;
import com.mansour.chattingapp.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(authentication.getPrincipal().toString());
        else
            throw new RuntimeException("Invalid credentials"); //TODO:: add custom exception
    }
}
