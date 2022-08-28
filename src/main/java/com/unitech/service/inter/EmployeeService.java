package com.unitech.service.inter;

import com.unitech.model.Employee;
import com.unitech.rest.model.dto.EmployeeDto;
import com.unitech.rest.model.dto.LoginRequestDto;
import com.unitech.rest.model.response.EmployeeResponse;
import com.unitech.rest.model.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {


    void insert(EmployeeDto employeeDto);

    LoginResponse login(String username ,String password);

   // LoginResponse login(LoginRequestDto loginRequestDto);
}
