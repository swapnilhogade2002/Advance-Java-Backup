package com.test.service;

import com.test.entity.EmployeeInfo;
import com.test.repository.EmployeeInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Autowired
	private EmployeeInfoRepo employeeInfoRepo;

	@Autowired
	private EmployeeInfoService employeeInfoService;

	@Override
	public EmployeeInfo saveEmployeeInfo(EmployeeInfo employee) {
		return employeeInfoRepo.save(employee);
	}

	@Override
	public EmployeeInfo getEmployeeInfo(Long id) {
		Optional<EmployeeInfo> employeeInfoOptional = employeeInfoRepo.findById(id);
		return employeeInfoOptional.orElse(null);
	}

	@Override
	public void deleteEmployeeInfo(Long id) {
		employeeInfoRepo.deleteById(id);
	}

	@Override
	public List<EmployeeInfo> getAllEmployee() {
		return employeeInfoRepo.findAll();
	}

//	total Count on UI
	@Override
	public long getTotalCount() {
		System.out.println(employeeInfoRepo.count());
		return employeeInfoRepo.count();
	}

	@Override
	public long getCountByGender(String gender) {
		return employeeInfoRepo.countByGender(gender);
	}

	@Override
	public long getCountByMaritalStatus(String maritalStatus) {
		return employeeInfoRepo.countByMaritalStatus(maritalStatus);
	}

	@Override
	public long getCountByEducationLevel(String educationLevel) {
		return employeeInfoRepo.countByEducationLevel(educationLevel);
	}

//	pagination

	@Override
	public Page<EmployeeInfo> getAllEmployee(Pageable pageable) {
		return employeeInfoRepo.findAll(pageable);
	}

	@Override
	public Page<EmployeeInfo> searchEmployee(String keyword, Pageable pageable) {
		return employeeInfoRepo.searchEmployee(keyword, pageable);
	}
}
