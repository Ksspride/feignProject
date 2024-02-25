package com.example.itmanagementservice.repo;

import com.example.itmanagementservice.entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetTypeRepository extends JpaRepository<AssetType, Long> {

    @Query(value = "select * from asset_types where emp_id=?", nativeQuery = true)
    List<AssetType> findByEmpId(String id);
}
