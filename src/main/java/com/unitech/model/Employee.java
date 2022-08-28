package com.unitech.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int age;
    private String name;
    private String surname;

    @Email
    private String email;

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private LocalDate birthDay;
    private String pin;
}
