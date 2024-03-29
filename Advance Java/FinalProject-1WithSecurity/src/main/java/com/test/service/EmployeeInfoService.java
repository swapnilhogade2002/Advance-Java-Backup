package com.test.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.entity.EmployeeInfo;

public interface EmployeeInfoService {

	public EmployeeInfo saveEmployeeInfo(EmployeeInfo employee);

	EmployeeInfo getEmployeeInfo(Long id);

	void deleteEmployeeInfo(Long id);

//	UI data
	List<EmployeeInfo> getAllEmployee();

	long getTotalCount();

	long getCountByGender(String gender);

	long getCountByMaritalStatus(String maritalStatus);

	long getCountByEducationLevel(String educationLevel);

	// Method to get all employees with pagination
	Page<EmployeeInfo> getAllEmployee(Pageable pageable);

	// Method to search employees by keyword with pagination
	Page<EmployeeInfo> searchEmployee(String keyword, Pageable pageable);

}
