package com.unitech.rest.model.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
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
