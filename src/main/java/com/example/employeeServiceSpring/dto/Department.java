package com.example.employeeServiceSpring.dto;

import lombok.*;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	
	
	private Long id;
    private String name;
    private String location;
    private String head;

}
