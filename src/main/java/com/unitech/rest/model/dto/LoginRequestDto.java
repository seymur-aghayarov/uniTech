package com.unitech.rest.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private int id;
    private int age;
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    private LocalDate birthDay;
    private String pin;
}
