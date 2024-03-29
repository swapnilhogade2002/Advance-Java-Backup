package com.test.service;

import com.test.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public void removeSessionMessage();

	public Employee getEmployeeByname(String email);

	boolean existsByEmail(String email);

}
