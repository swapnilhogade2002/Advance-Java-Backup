package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

//	user login

	public boolean verifyLogin(String userName, String password) {
		Employee employee = employeeRepository.findByUserName(userName);

		if (employee != null && employee.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

}
