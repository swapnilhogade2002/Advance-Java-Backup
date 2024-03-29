package com.test.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeAPIService {

	// Update the URL to the new API endpoint
	private final String apiUrl = "https://api.example.com/v1/employees";

	private final RestTemplate restTemplate;

	public EmployeeAPIService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String fetchEmployeeData() {
		// Make a GET request to the external API
		return restTemplate.getForObject(apiUrl, String.class);
	}
}
