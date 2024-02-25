package com.example.employeeservice.service.impl;

import com.example.employeeservice.CacheTestService;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.feign.client.ItManagementServiceClient;
import com.example.employeeservice.models.EmployeeAssetsDto;
import com.example.employeeservice.models.EmployeeDto;
import com.example.employeeservice.repo.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.utils.ObjectMapperUtils;
import com.example.itmanagementservice.models.AssetTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ItManagementServiceClient itManagementServiceClient;

    @Autowired
    private CacheTestService cacheTestService;

//    @Autowired
//    RestTemplate restTemplate;
    @Override
    public EmployeeDto createEmployee(EmployeeDto request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmpId(request.getEmpId());
        employee.setMobileNumber(request.getMobileNumber());
        Employee savedEmployee = employeeRepository.save(employee);
        cacheTestService.updateEmployee(1L, ObjectMapperUtils.mapAll(employeeRepository.findAll(), EmployeeDto.class));
        return ObjectMapperUtils.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeAssetsDto getEmployeeById(String id) {
        EmployeeAssetsDto savedEmployeeAssets = ObjectMapperUtils.map(employeeRepository.findByEmpId(id), EmployeeAssetsDto.class);
        ResponseEntity<List<AssetTypeDto>> assets = itManagementServiceClient.getAssetByEmpId(id);
        if(assets.getStatusCode().equals(HttpStatus.OK)){
            savedEmployeeAssets.setAssetTypeList(assets.getBody());
        }
        return savedEmployeeAssets;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

        return cacheTestService.getEmployee(1L);
        //return ObjectMapperUtils.mapAll(employeeRepository.findAll(), EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
