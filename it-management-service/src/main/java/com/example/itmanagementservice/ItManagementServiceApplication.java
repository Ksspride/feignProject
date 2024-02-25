package com.example.itmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ItManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItManagementServiceApplication.class, args);
	}

}
