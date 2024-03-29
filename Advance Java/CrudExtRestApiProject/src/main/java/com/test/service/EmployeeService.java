package com.test.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.model.Employee;

@Service
public class EmployeeService {
	private static final String EXTERNAL_API_URL = "https://dummy.restapiexample.com/api/v1/employees";

	private final RestTemplate restTemplate;

	public EmployeeService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Employee[] fetchEmployeesFromApi() {
		return restTemplate.getForObject(EXTERNAL_API_URL, Employee[].class);
	}

}
