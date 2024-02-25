package com.example.employeeservice.repo;

import com.example.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmpId(String id);

    Employee findByMobileNumber(Long number);
}
