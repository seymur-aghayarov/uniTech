package com.unitech.controller;

import com.unitech.rest.model.dto.EmployeeDto;
import com.unitech.rest.model.dto.LoginRequestDto;
import com.unitech.rest.model.response.EmployeeResponse;
import com.unitech.rest.model.response.LoginResponse;
import com.unitech.service.inter.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> singUp(@RequestBody EmployeeDto employeeDto){
        employeeService.insert(employeeDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/log-in/")
    public LoginResponse getByUsernameAndPassword(@RequestBody LoginRequestDto loginRequestDto){
      return employeeService.login(loginRequestDto.getUsername(),loginRequestDto.getPassword());
    }
}
