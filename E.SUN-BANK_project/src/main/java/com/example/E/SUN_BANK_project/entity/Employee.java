package com.example.E.SUN_BANK_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "EMP_ID")
	private int empId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FLOOR_SEAT_SEQ")
	private int floorSeatSEQ;

	public Employee(int empId, String name, String email, int floorSeatSEQ) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.floorSeatSEQ = floorSeatSEQ;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFloorSeatSEQ() {
		return floorSeatSEQ;
	}

	public void setFloorSeatSEQ(int floorSeatSEQ) {
		this.floorSeatSEQ = floorSeatSEQ;
	}

	
}
