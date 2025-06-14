package com.example.E.SUN_BANK_project.ifs;

import java.util.List;

import com.example.E.SUN_BANK_project.entity.Employee;
import com.example.E.SUN_BANK_project.vo.BasicRes;
import com.example.E.SUN_BANK_project.vo.ClearEmpSeatReq;
import com.example.E.SUN_BANK_project.vo.EmployeeReq;
import com.example.E.SUN_BANK_project.vo.GetAllRes;

public interface EmployeeService {
	
	public BasicRes updateSeat(EmployeeReq req);
	
//	public BasicRes getEmployeeSeat(int empId);
	
	public GetAllRes getAllEmployees();
	
	public List<Employee> search();
	
	public BasicRes clearEmpSeat(ClearEmpSeatReq req);
	
}
