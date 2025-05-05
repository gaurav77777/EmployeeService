package com.example.employeeServiceSpring.dto;

import com.example.employeeServiceSpring.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeWithDepartment {
	
	
	
	 private Employee employee;
	 private Department department;

}
