package com.example.E.SUN_BANK_project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.E.SUN_BANK_project.entity.SeatingChart;

import jakarta.persistence.Entity;

@Repository
public interface SeatingChartDao extends JpaRepository<SeatingChart, Integer> {

	@Query(value = "select FLOOR_SEAT_SEQ , FLOOR_NO , SEAT_NO from seating_chart", nativeQuery = true)
	public List<SeatingChart> getAll();

	@Query(value = "select count(FLOOR_SEAT_SEQ) from seating_chart where FLOOR_SEAT_SEQ = ?1 ", nativeQuery = true)
	public int existsBySeatId(int floorSeatSeq);

}
