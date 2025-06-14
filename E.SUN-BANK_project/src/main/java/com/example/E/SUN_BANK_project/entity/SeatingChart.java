package com.example.E.SUN_BANK_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seating_chart")
public class SeatingChart {

	@Id
	@Column(name = "FLOOR_SEAT_SEQ")
	private int floorSeatSEQ;

	@Column(name = "FLOOR_NO")
	private int floorNo;

	@Column(name = "SEAT_NO")
	private String SeatNo;

	public SeatingChart(int floorSeatSEQ, int floorNo, String seatNo) {
		super();
		this.floorSeatSEQ = floorSeatSEQ;
		this.floorNo = floorNo;
		SeatNo = seatNo;
	}

	public SeatingChart() {
		super();
	}

	public int getFloorSeatSEQ() {
		return floorSeatSEQ;
	}

	public void setFloorSeatSEQ(int floorSeatSEQ) {
		this.floorSeatSEQ = floorSeatSEQ;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public String getSeatNo() {
		return SeatNo;
	}

	public void setSeatNo(String seatNo) {
		SeatNo = seatNo;
	}

}
