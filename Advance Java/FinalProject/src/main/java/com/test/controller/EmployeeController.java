package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.entity.Employee;
import com.test.entity.LoginForm;
import com.test.service.AdminService;
import com.test.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	registration form

	@GetMapping("/employee/form")
	public String showEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-form";
	}

	@PostMapping("/employee/save")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee/form";
	}

//	login

	@GetMapping("/employee-login")
	public String showEmployeeLoginForm(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login-form";
	}

	@PostMapping("/login-save")
	public String processLogin(@ModelAttribute LoginForm loginForm, Model model) {
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();

		if (employeeService.verifyLogin(userName, password)) {
			// Successful login, redirect to a success page
			return "redirect:/success";
		} else {
			// Failed login, show an error message
			model.addAttribute("error", "Invalid username or password");
			return "login-form";
		}
	}

	@GetMapping("/success")
	public String showSuccessPage() {
		return "success";
	}

}
