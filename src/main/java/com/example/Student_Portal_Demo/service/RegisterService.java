package com.example.Student_Portal_Demo.service;

import com.example.Student_Portal_Demo.dto.RegisterRequestDto;
import com.example.Student_Portal_Demo.entity.Student;
import com.example.Student_Portal_Demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public void studentRegister(RegisterRequestDto request){
        Student student = new Student();
        student.setStudentName(request.getStudentName());
        student.setEmail(request.getEmail());
        String encodePassword = passwordEncoder.encode(request.getPassword());
        student.setPassword(encodePassword);
        student.setRole("ROLE_STUDENT");
        studentRepository.save(student);
    }


}
