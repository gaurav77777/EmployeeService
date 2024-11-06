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
            Employee employee = new Employee(1L, "John Doe", "Software Engineer", 60000);

            // Save the employee to the database
            employeeRepository.save(employee);

            // Optionally, print a message to confirm it was saved
            System.out.println("Employee saved: " + employee.getName());
        };
    }

}
