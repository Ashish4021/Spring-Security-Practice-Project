package com.example.Student_Portal_Demo.controller;

import com.example.Student_Portal_Demo.dto.RegisterRequestDto;
import com.example.Student_Portal_Demo.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@AllArgsConstructor
public class RegisterController {
    private final RegisterService registerService;


    @PostMapping
    public ResponseEntity<String> registerStudent(@RequestBody RegisterRequestDto registerRequestDto){
        registerService.studentRegister(registerRequestDto);
        return ResponseEntity.ok("Student Registered Successfully!");

    }
}
