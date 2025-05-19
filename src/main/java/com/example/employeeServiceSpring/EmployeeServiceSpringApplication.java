package com.example.employeeServiceSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.employeeServiceSpring.entity.Employee;
import com.example.employeeServiceSpring.repository.EmployeeRepository;




@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeServiceSpringApplication {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	// Single logger for the whole application
    public static final Logger logger = LoggerFactory.getLogger(EmployeeServiceSpringApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceSpringApplication.class, args);
		 logger.info("Application started successfully!------------->");
	}
	
	
	@Bean
    public CommandLineRunner run() {
        return args -> {
            // Create an Employee object
            Employee employee = new Employee(1L, "John Doe", "Software Engineer","JohnDoe@gmail.com", 70000, 1L);
            Employee employee2 = new Employee(2L, "Jane Smith", "Project Manager", "JaneSmith@gmail.com", 85000, 1L);
            Employee employee3 = new Employee(3L, "David Johnson", "QA Engineer", "DavidJohnson@gmail.com", 70000, 1L);
            
            

            // Save the employee to the database
            employeeRepository.save(employee);
            employeeRepository.save(employee2);
            employeeRepository.save(employee3);

            // Optionally, print a message to confirm it was saved
            System.out.println("Employee saved: " + employee.getName());
        };
    }

}
