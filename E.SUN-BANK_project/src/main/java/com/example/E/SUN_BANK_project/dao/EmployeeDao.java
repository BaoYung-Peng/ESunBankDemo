package com.example.E.SUN_BANK_project.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.E.SUN_BANK_project.entity.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	// 員工更新座位（需傳入 empId 才不會改到全部）
	@Modifying
	@Transactional
	@Query(value = "update employee set FLOOR_SEAT_SEQ = :seat where EMP_ID = :empId", nativeQuery = true)
	public void updateSeat(@Param("seat") int floorSeatSEQ, @Param("empId") int empId);

	// 查該座位是否有人佔用
	@Query(value = "select count(FLOOR_SEAT_SEQ) from employee where FLOOR_SEAT_SEQ = ?1", nativeQuery = true)
	public int ownSeat(int floorSeatSEQ);

	// 查所有員工
	@Query(value = "select EMP_ID , NAME , EMAILL , FLOOR_SEAT_SEQ from employee", nativeQuery = true)
	public List<Employee> getAll();

	// 查單一員工的座位
	@Query(value = "SELECT * FROM employee WHERE emp_id = :empId", nativeQuery = true)
	public void getByEmpId(@Param("empId") int empId);
	
	// 查詢沒有座位的員工
	@Query(value = "SELECT * FROM employee WHERE FLOOR_SEAT_SEQ = 0 ", nativeQuery = true)
	public List<Employee> Search();
	
	// 查詢有座位的員工
	@Query(value = "SELECT * FROM employee WHERE FLOOR_SEAT_SEQ != 0 ", nativeQuery = true)
	public List<Employee> getEmpSeat();
	
	// 清除在座位上的員工編號
	@Modifying
	@Transactional
	@Query(value = "UPDATE employee SET FLOOR_SEAT_SEQ = 0 WHERE EMP_ID = ?1", nativeQuery = true)
	public void clearEmpSeat(int empId);
}
