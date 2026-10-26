package com.example.Student_Portal_Demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "Email is Required!")
    private String email;

    @NotBlank
    @Size(min=8, message = "Password must have 8 characters!")
    private String password;
}
