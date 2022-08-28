package com.unitech.service.impl;

import com.unitech.codeEnum.ErrorCodeEnum;
import com.unitech.exception.UniTechException;
import com.unitech.model.Employee;
import com.unitech.repository.EmployeeRepository;
import com.unitech.rest.model.dto.EmployeeDto;
import com.unitech.rest.model.response.LoginResponse;
import com.unitech.service.inter.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public void insert(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeRepository.save(employee);
    }

    @Override
    public LoginResponse login(String username, String password) {
        Optional<Employee> employee = employeeRepository.findByUsernameAndPassword(username, password);
        return employee.map(employee1 -> convertToLoginResponse(employee1))
                .orElseThrow(() -> new UniTechException(ErrorCodeEnum.VALIDATION_ERRORS));
    }


    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

    private LoginResponse convertToLoginResponse(Employee emp) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken("accessToken");
        return loginResponse;
    }

}
