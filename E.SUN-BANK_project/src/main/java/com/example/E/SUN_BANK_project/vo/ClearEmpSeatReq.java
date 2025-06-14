package com.example.E.SUN_BANK_project.vo;

public class ClearEmpSeatReq {
	private int empId; // 員工編號

	public ClearEmpSeatReq(int empId) {
		super();
		this.empId = empId;
	}

	public ClearEmpSeatReq() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
