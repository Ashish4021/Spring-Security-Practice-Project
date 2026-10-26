package com.example.Student_Portal_Demo.service;

import com.example.Student_Portal_Demo.entity.Student;
import com.example.Student_Portal_Demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final StudentRepository studentRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Student not found!"));

        return User.builder()
                .username(student.getEmail())   
                .password(student.getPassword())
                .authorities(student.getRole())
                .build();
    }
}
