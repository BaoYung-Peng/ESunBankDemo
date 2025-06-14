package com.example.E.SUN_BANK_project.vo;

import java.util.List;

import com.example.E.SUN_BANK_project.entity.Employee;
import com.example.E.SUN_BANK_project.entity.SeatingChart;

public class GetAllRes extends BasicRes {
	
	private List<SeatingChart> seatingChartList;
	
	private List<Employee> employeeList;
	
	public GetAllRes(int code, String message, List<SeatingChart> seatingChartList, List<Employee> employeeList) {
		super(code, message);
		this.seatingChartList = seatingChartList;
		this.employeeList = employeeList;
	}

	public GetAllRes() {
		super();
	}

	public GetAllRes(int code, String message) {
		super(code, message);
	}

	public List<SeatingChart> getSeatingChartList() {
		return seatingChartList;
	}

	public void setSeatingChartList(List<SeatingChart> seatingChartList) {
		this.seatingChartList = seatingChartList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}
