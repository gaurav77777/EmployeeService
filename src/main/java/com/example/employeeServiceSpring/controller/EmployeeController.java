package com.example.employeeServiceSpring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeServiceSpring.EmployeeServiceSpringApplication;
import com.example.employeeServiceSpring.dto.EmployeeWithDepartment;
import com.example.employeeServiceSpring.entity.Employee;
import com.example.employeeServiceSpring.service.EmployeeService;



@RestController
@RequestMapping("/api/employees")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	  // Using the logger from MyApplication (same logger across the app)
    private static final Logger logger = EmployeeServiceSpringApplication.logger;


    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
    	 logger.info("Inside getAllEmployees");
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    	logger.info("Inside getEmployeeById");
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    	logger.info("Inside createEmployee");
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    	logger.info("Inside updateEmployee");
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employee.setId(id);  // Ensure the employee's ID remains the same
            Employee updatedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    	logger.info("Inside deleteEmployee");
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    
    
    
    @GetMapping("/employees/{id}/with-department")
    public EmployeeWithDepartment getEmployeeWithDepartment(@PathVariable Long id) {
        return employeeService.getEmployeeWithDepartment(id);
    }
	
	

}
