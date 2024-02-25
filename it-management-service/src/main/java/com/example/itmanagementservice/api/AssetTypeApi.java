package com.example.itmanagementservice.api;

import com.example.itmanagementservice.models.AssetTypeDto;
import com.example.itmanagementservice.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetTypeApi {

    @Autowired
    private AssetTypeService assetTypeService;


    @PostMapping()
    public ResponseEntity<AssetTypeDto> createAssetType(@RequestBody AssetTypeDto request){
        return ResponseEntity.ok().body(assetTypeService.createAssetType(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetTypeDto> getAssetById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(assetTypeService.getAssetTypeById(id));
    }

    @GetMapping()
    public ResponseEntity<List<AssetTypeDto>> getAllAssets(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(assetTypeService.getAllAssetType());
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<List<AssetTypeDto>> getAssetByEmpId(@PathVariable("id") String id){
        return ResponseEntity.ok().body(assetTypeService.getAllAssetByEmployeeId(id));
    }
}
