package com.example.itmanagementservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetTypeDto {
    private Long id;
    private String name;
    private String description;
    private String empId;
}
