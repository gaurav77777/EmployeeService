package com.example.employeeServiceSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeServiceSpring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
