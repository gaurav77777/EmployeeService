package com.example.employeeServiceSpring.service;

import com.example.employeeServiceSpring.dto.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




//Replace with your actual department-service base URL or service name
@FeignClient(name = "department-service", url = "http://localhost:8081")
public interface DepartmentClient {
	
	
	@GetMapping("/departments/{id}")
    Department getDepartmentById(@PathVariable("id") Long id);
	

}
