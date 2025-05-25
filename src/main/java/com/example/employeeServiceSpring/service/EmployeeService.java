package com.example.employeeServiceSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.example.employeeServiceSpring.dto.Department;
import com.example.employeeServiceSpring.dto.EmployeeWithDepartment;
import com.example.employeeServiceSpring.entity.Employee;
import com.example.employeeServiceSpring.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
		@Autowired
	    private final CircuitBreakerFactory<?, ?> circuitBreakerFactory;
	
		@Autowired
	    private EmployeeRepository employeeRepository;
		
		@Autowired
		private DepartmentClient departmentClient;
		
		
		
		
		@Autowired
	    public EmployeeService(EmployeeRepository employeeRepository,
	                           DepartmentClient departmentClient,
	                           CircuitBreakerFactory<?, ?> circuitBreakerFactory) {
	        this.employeeRepository = employeeRepository;
	        this.departmentClient = departmentClient;
	        this.circuitBreakerFactory = circuitBreakerFactory;
	    }
		
		 
		 public EmployeeWithDepartment getEmployeeWithDepartment(Long id) {
		        Employee employee = employeeRepository.findById(id).orElseThrow();
		        
		        //Department department = departmentClient.getDepartmentById(employee.getDepartmentId());
		        
		        // Wrap the remote call in the circuit breaker
		        Department department = circuitBreakerFactory.create("departmentServiceCB")
		                .run(
		                        () -> departmentClient.getDepartmentById(employee.getDepartmentId()),
		                        throwable -> getFallbackDepartment(employee.getDepartmentId(), throwable)
		                );
		        return EmployeeWithDepartment.builder()
		                .employee(employee)
		                .department(department)
		                .build();
		    }
		 
		 
		// Fallback method
		    private Department getFallbackDepartment(Long deptId, Throwable t) {
		        // You can log the exception if needed
		        return Department.builder()
		                .id(deptId)
		                .name("Unknown Department")
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
