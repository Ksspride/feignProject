package com.example.employeeservice;


import com.example.employeeservice.models.EmployeeDto;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = "Test")
@Service
public class CacheTestService {

    @CachePut(key="#id")
    public List<EmployeeDto> updateEmployee(Long id, List<EmployeeDto> employeeDto){
        return employeeDto;
    }

    @Cacheable(key = "#id")
    public List<EmployeeDto> getEmployee(Long id){
        return new ArrayList<>();
    }

    @CacheEvict(key = "#id")
    public  void clearEmployee(Long id){
        // document why this method is empty
    }
}
