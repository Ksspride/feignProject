package com.example.employeeservice.api;


import com.example.employeeservice.models.EmployeeAssetsDto;
import com.example.employeeservice.models.EmployeeDto;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto request){
        return ResponseEntity.ok().body(employeeService.createEmployee(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeAssetsDto> getEmployeeById(@PathVariable("id") String id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
