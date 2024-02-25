package com.example.employeeservice.models;


import com.example.itmanagementservice.models.AssetTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAssetsDto {
    private Long id;
    private String name;
    private String empId;
    private Long mobileNumber;
    List<AssetTypeDto> assetTypeList;
}
