package com.example.employeemanager.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanager.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
