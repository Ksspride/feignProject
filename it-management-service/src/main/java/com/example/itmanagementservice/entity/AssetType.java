package com.example.itmanagementservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "asset_types")
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_itms_asset_types")
    @SequenceGenerator(name = "seq_itms_asset_types", sequenceName = "seq_itms_asset_types", initialValue = 3)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private String empId;
}
