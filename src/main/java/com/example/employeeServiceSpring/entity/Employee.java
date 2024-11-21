package com.example.employeeServiceSpring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
    private Long id;
    private String name;
    //private String designation;
    private String position;    // Changed to match Angular's 'position' instead of 'designation'
    private String email;       // Added 'email' field to match Angular interface
    
    private double salary;

    // Constructors
    public Employee() {}

	public Employee(Long id, String name, String position, String email, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.email = email;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

    

}
