package com.unitech.repository;

import com.unitech.model.Employee;
import com.unitech.rest.model.dto.LoginRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
      Optional<Employee> findByUsernameAndPassword (String username , String password);
}
