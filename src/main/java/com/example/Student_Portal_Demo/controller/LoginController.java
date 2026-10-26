package com.example.Student_Portal_Demo.controller;

import com.example.Student_Portal_Demo.configuration.SecurityConfig;
import com.example.Student_Portal_Demo.dto.LoginRequestDto;
import com.example.Student_Portal_Demo.service.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        String token = jwtService.generateToken(loginRequest.getEmail());
        return ResponseEntity.ok(token);
    }


}
