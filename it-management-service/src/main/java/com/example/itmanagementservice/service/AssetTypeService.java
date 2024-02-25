package com.example.itmanagementservice.service;

import com.example.itmanagementservice.models.AssetTypeDto;

import java.util.List;

public interface AssetTypeService {

    AssetTypeDto createAssetType(AssetTypeDto request);

    AssetTypeDto getAssetTypeById(Long id);

    List<AssetTypeDto> getAllAssetType();

    List<AssetTypeDto> getAllAssetByEmployeeId(String id);
}
