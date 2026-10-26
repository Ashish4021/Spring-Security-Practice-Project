package com.example.Student_Portal_Demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @PreAuthorize("hasAnyRole('STUDENT,'ADMIN')")
    @GetMapping("/profile")
    public String profile(){
        return "Student Successfully Accessed!";
    }
}
