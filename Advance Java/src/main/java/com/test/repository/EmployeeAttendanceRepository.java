package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.EmployeeAttendance;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {
	List<EmployeeAttendance> findByEmployeeId(String employeeId);
}