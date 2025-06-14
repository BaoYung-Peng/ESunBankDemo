package com.example.E.SUN_BANK_project.vo;

public class EmployeeReq {
	
	private int empId;         // 員工編號
	private int floorSeatSEQ;  // 要指派的座位編號

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getFloorSeatSEQ() {
		return floorSeatSEQ;
	}

	public void setFloorSeatSEQ(int floorSeatSEQ) {
		this.floorSeatSEQ = floorSeatSEQ;
	}

	public EmployeeReq() {
		super();
	}

	public EmployeeReq(int empId, int floorSeatSEQ) {
		super();
		this.empId = empId;
		this.floorSeatSEQ = floorSeatSEQ;
	}
}
