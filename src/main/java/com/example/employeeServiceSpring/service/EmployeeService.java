package com.example.employeeServiceSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeServiceSpring.dto.Department;
import com.example.employeeServiceSpring.dto.EmployeeWithDepartment;
import com.example.employeeServiceSpring.entity.Employee;
import com.example.employeeServiceSpring.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
		@Autowired
	    private EmployeeRepository employeeRepository;
		
		@Autowired
		private DepartmentClient departmentClient;
		
		
		
		
		
		
		
		 public EmployeeWithDepartment getEmployeeWithDepartment(Long id) {
		        Employee employee = employeeRepository.findById(id).orElseThrow();
		        Department department = departmentClient.getDepartmentById(employee.getDepartmentId());

		        return EmployeeWithDepartment.builder()
		                .employee(employee)
		                .department(department)
		                .build();
		    }

	    // Get all employees
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    // Get a single employee by ID
	    public Optional<Employee> getEmployeeById(Long id) {
	        return employeeRepository.findById(id);
	    }

	    // Create or update an employee
	    public Employee saveEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    // Delete an employee by ID
	    public void deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	    }

}
