package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.EmployeeAttendance;
import com.test.repository.EmployeeAttendanceRepository;

@Service
public class EmployeeAttendanceService {

    @Autowired
    private EmployeeAttendanceRepository employeeAttendanceRepository;

    public List<EmployeeAttendance> getAllEmployeeAttendance() {
        return employeeAttendanceRepository.findAll();
    }

	public List<EmployeeAttendance> findByEmployeeId(String employeeId) {
		return employeeAttendanceRepository.findByEmployeeId(employeeId);
	}


}