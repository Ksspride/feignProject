package com.example.itmanagementservice.service.impl;

import com.example.itmanagementservice.entity.AssetType;
import com.example.itmanagementservice.models.AssetTypeDto;
import com.example.itmanagementservice.repo.AssetTypeRepository;
import com.example.itmanagementservice.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetTypeServiceImpl implements AssetTypeService {

    @Autowired
    AssetTypeRepository assetTypeRepository;
    @Override
    public AssetTypeDto createAssetType(AssetTypeDto request) {
        AssetType assetType =new AssetType();
        assetType.setName(request.getName());
        assetType.setDescription(request.getDescription());
        assetType.setEmpId(request.getEmpId());
        request.setId(assetTypeRepository.save(assetType).getId());
        return request;
    }

    @Override
    public AssetTypeDto getAssetTypeById(Long id) {
        AssetType assetType = assetTypeRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        AssetTypeDto assetTypeDto =new AssetTypeDto();
        assetTypeDto.setId(assetType.getId());
        assetTypeDto.setName(assetType.getName());
        assetTypeDto.setDescription(assetType.getDescription());
        return assetTypeDto;
    }

    @Override
    public List<AssetTypeDto> getAllAssetType() {
        return null;
    }

    @Override
    public List<AssetTypeDto> getAllAssetByEmployeeId(String id) {
        List<AssetTypeDto> newList = new ArrayList<>();
        List<AssetType> savedList = assetTypeRepository.findByEmpId(id);
        for(AssetType assetType : savedList){
            AssetTypeDto assetTypeDto = new AssetTypeDto();
            assetTypeDto.setId(assetType.getId());
            assetTypeDto.setName(assetType.getName());
            assetTypeDto.setEmpId(assetType.getEmpId());
            assetTypeDto.setDescription(assetType.getDescription());
            newList.add(assetTypeDto);
        }
        return newList;
    }
}
