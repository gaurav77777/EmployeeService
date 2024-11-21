package com.example.employeeServiceSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.employeeServiceSpring.entity.Employee;
import com.example.employeeServiceSpring.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeServiceSpringApplication {
	
	@Autowired
    private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceSpringApplication.class, args);
	}
	
	
	@Bean
    public CommandLineRunner run() {
        return args -> {
            // Create an Employee object
            Employee employee = new Employee(1L, "John Doe", "Software Engineer","JohnDoe@gmail.com", 70000);
            Employee employee2 = new Employee(2L, "Jane Smith", "Project Manager", "JaneSmith@gmail.com", 85000);
            Employee employee3 = new Employee(3L, "David Johnson", "QA Engineer", "DavidJohnson@gmail.com", 70000);
            
            

            // Save the employee to the database
            employeeRepository.save(employee);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);

            // Optionally, print a message to confirm it was saved
            System.out.println("Employee saved: " + employee.getName());
        };
    }

}
