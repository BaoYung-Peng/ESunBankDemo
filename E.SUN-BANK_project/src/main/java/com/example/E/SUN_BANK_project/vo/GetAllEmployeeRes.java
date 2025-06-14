package com.example.E.SUN_BANK_project.vo;

import java.util.List;

import com.example.E.SUN_BANK_project.entity.Employee;

public class GetAllEmployeeRes extends BasicRes {

	private List<Employee> empList;

	public GetAllEmployeeRes(int code, String message, List<Employee> list) {
		super(code, message);
		this.empList = list;
	}

	public GetAllEmployeeRes() {
		super();
	}

	public GetAllEmployeeRes(int code, String message) {
		super(code, message);
	}

	public List<Employee> getList() {
		return empList;
	}

	public void setList(List<Employee> list) {
		this.empList = list;
	}

}
