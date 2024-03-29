package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.service.EmployeeAPIService;

@Controller
public class EmployeeController {

	private final EmployeeAPIService employeeAPIService;

	public EmployeeController(EmployeeAPIService employeeAPIService) {
		this.employeeAPIService = employeeAPIService;
	}

	@GetMapping("/employees")
	public String displayEmployees(Model model) {
		// Fetch employee data from the external API
		String employeeData = employeeAPIService.fetchEmployeeData();
		System.out.println(employeeData);

		// Add the employee data to the model for Thymeleaf
		model.addAttribute("employeeData", employeeData);

		// Return the Thymeleaf template name
		return "display";
	}
}
