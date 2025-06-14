package com.example.E.SUN_BANK_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.E.SUN_BANK_project.entity.Employee;
import com.example.E.SUN_BANK_project.ifs.EmployeeService;
import com.example.E.SUN_BANK_project.vo.BasicRes;
import com.example.E.SUN_BANK_project.vo.ClearEmpSeatReq;
import com.example.E.SUN_BANK_project.vo.EmployeeReq;

@CrossOrigin
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "employee/updateSeat")
	public BasicRes updateSeat(@RequestBody EmployeeReq req) {
		return employeeService.updateSeat(req);
	}
	
	@GetMapping(value = "employee/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.search();
	}

	// 清除員工編號 只保留坐位
	@PostMapping(value = "employee/clearEmpSeat")
	public BasicRes clearSeat(@RequestBody ClearEmpSeatReq req) {
	    return employeeService.clearEmpSeat(req);
	}
	
}
