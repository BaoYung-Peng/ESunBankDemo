package com.example.E.SUN_BANK_project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E.SUN_BANK_project.constants.ResMessage;
import com.example.E.SUN_BANK_project.dao.EmployeeDao;
import com.example.E.SUN_BANK_project.dao.SeatingChartDao;
import com.example.E.SUN_BANK_project.entity.Employee;
import com.example.E.SUN_BANK_project.entity.SeatingChart;
import com.example.E.SUN_BANK_project.ifs.SeatChartService;
import com.example.E.SUN_BANK_project.vo.GetAllRes;

@Service
public class SeatChartServiceImpl implements SeatChartService {

	@Autowired
	private SeatingChartDao seatingChartDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public GetAllRes getAllSeat() {
		List<SeatingChart> seatlist = seatingChartDao.getAll();
		List<Employee> emplist = employeeDao.getEmpSeat();
		return new GetAllRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), seatlist, emplist);
	}

}
