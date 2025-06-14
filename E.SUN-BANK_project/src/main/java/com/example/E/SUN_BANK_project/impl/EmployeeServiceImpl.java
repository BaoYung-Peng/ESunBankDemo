package com.example.E.SUN_BANK_project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E.SUN_BANK_project.constants.ResMessage;
import com.example.E.SUN_BANK_project.dao.EmployeeDao;
import com.example.E.SUN_BANK_project.dao.SeatingChartDao;
import com.example.E.SUN_BANK_project.entity.Employee;
import com.example.E.SUN_BANK_project.entity.SeatingChart;
import com.example.E.SUN_BANK_project.ifs.EmployeeService;
import com.example.E.SUN_BANK_project.vo.BasicRes;
import com.example.E.SUN_BANK_project.vo.ClearEmpSeatReq;
import com.example.E.SUN_BANK_project.vo.EmployeeReq;
import com.example.E.SUN_BANK_project.vo.GetAllEmployeeRes;
import com.example.E.SUN_BANK_project.vo.GetAllRes;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private SeatingChartDao seatingChartDao;

	@Override
	public BasicRes updateSeat(EmployeeReq req) {
		// 檢查座位是否存在
		int isExist = seatingChartDao.existsBySeatId(req.getFloorSeatSEQ());
		if (isExist == 0) {
			return new BasicRes(ResMessage.SEAT_NOT_FOUND.getCode(), ResMessage.SEAT_NOT_FOUND.getMessage());
		}

		// 查詢座位是否有員工占用
		int ownerSeat = employeeDao.ownSeat(req.getFloorSeatSEQ());
		if (ownerSeat == 1) {
			return new BasicRes(ResMessage.SEAT_OCCUPIED.getCode(), ResMessage.SEAT_OCCUPIED.getMessage());
		}

		// 指定該員工的座位
		employeeDao.updateSeat(req.getFloorSeatSEQ(), req.getEmpId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}

	// 查詢員工的座位
//	@Override
//	public BasicRes getEmployeeSeat(int empId) {
//		Employee employee = employeeDao.findById(empId).orElse(null);
//		if (employee == null) {
//			return new BasicRes(ResMessage.EMPLOYEE_NOT_FOUND.getCode(), ResMessage.EMPLOYEE_NOT_FOUND.getMessage());
//		}
//
//		// 表示沒有分配座位
//		if (employee.getFloorSeatSEQ() == 0) {
//			return new BasicRes(ResMessage.SEAT_NOT_FOUND.getCode(), "該員工尚未分配座位");
//		}
//
//		SeatingChart seat = seatingChartDao.findById(employee.getFloorSeatSEQ()).orElse(null);
//		if (seat == null) {
//			return new BasicRes(ResMessage.SEAT_NOT_FOUND.getCode(), ResMessage.SEAT_NOT_FOUND.getMessage());
//		}
//
//		return new BasicRes(ResMessage.SUCCESS.getCode(), //
//				ResMessage.SUCCESS.getMessage());
//	}

	// 查詢沒有坐位的員工
	@Override
	public List<Employee> search() {
		List<Employee> list = employeeDao.Search();
		return list;
	}

	@Override
	public GetAllRes getAllEmployees() {

		return null;
	}

	@Override
	public BasicRes clearEmpSeat(ClearEmpSeatReq req) {
		employeeDao.clearEmpSeat(req.getEmpId());
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

}
