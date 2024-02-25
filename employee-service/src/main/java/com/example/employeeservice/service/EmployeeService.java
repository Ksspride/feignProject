package com.example.employeeservice.service;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.models.EmployeeAssetsDto;
import com.example.employeeservice.models.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto createEmployee(EmployeeDto request);

    public EmployeeAssetsDto getEmployeeById(String id);

    public List<EmployeeDto> getAllEmployee();

    public void deleteEmployee(Long id);
}
