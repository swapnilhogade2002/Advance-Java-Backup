package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.test.entity.LoginForm;
import com.test.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin-login")
	public String showLoginForm(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "AdminLoginForm";
	}

	@PostMapping("/admin-save")
	public String processAdmin(@ModelAttribute LoginForm loginForm, Model model) {
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();

		if (adminService.verifyAdminLogin(userName, password)) {
			// Successful login for admin, redirect to the admin dashboard
			return "redirect:/AdminDashboard";
		} else {
			// Failed login, show an error message
			model.addAttribute("error", "Invalid username or password");
			return "login-form";
		}
	}

	@GetMapping("/admin-dashboard")
	public String showSuccessPage() {
		return "admin-dashboard";
	}
}
