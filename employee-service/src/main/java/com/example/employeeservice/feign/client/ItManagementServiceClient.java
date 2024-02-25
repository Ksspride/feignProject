package com.example.employeeservice.feign.client;

import com.example.itmanagementservice.models.AssetTypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "IT-MANAGEMENT-SERVICE")
public interface ItManagementServiceClient {

    @GetMapping("/asset/emp/{id}")
    public ResponseEntity<List<AssetTypeDto>> getAssetByEmpId(@PathVariable("id") String id);


}
