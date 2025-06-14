package com.example.E.SUN_BANK_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.E.SUN_BANK_project.ifs.SeatChartService;
import com.example.E.SUN_BANK_project.vo.BasicRes;
import com.example.E.SUN_BANK_project.vo.GetAllRes;

@CrossOrigin
@RestController
public class SeatChartController {

	@Autowired
	private SeatChartService seatChartService;

	
	@GetMapping(value = "seatChart/getAll")
	public GetAllRes getAllseatChart() {
		return seatChartService.getAllSeat();
	}
	
	
}
