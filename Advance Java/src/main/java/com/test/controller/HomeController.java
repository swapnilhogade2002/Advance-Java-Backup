package com.test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepo;
import com.test.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	private EmployeeRepo employeeRepo;

	@ModelAttribute
	public void commanUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			Employee employee = employeeRepo.findByEmail(email);
			m.addAttribute("employee", employee);

		}

	}

	@GetMapping("/")
	public String index() {
		return ("index");
	}

	@GetMapping("/register")
	public String register() {
		return ("register");
	}

	@GetMapping("/login")
	public String signin() {
		return ("login");
	}
	
	 @GetMapping("/logout")
	    public String logout(HttpServletResponse response, HttpServletRequest request ) {
	        // Expire the session
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }

	        // Set headers to prevent caching
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	        response.setDateHeader("Expires", 0); // Proxies.

	        return "redirect:/login?logout";
	    }

//	@GetMapping("/employee/profile")
//	public String profile(Principal p, Model m) {
//		String name = p.getName();
//		Employee employee = employeeRepo.findByEmail(name);
//		m.addAttribute("employee", employee);
//		return ("profile");
//	}
//
//	@GetMapping("/employee/home")
//	public String home() {
//		return ("home");
//	}

//	save user

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute Employee employee, Model model) {
		Employee saveEmployee = employeeService.saveEmployee(employee);

		if (saveEmployee != null) {
			System.out.println("Successfully registered!");
			model.addAttribute("registrationSuccess", true);
		} else {
			System.out.println("Registration failed. Please try again.");
		}

		return "redirect:/login";
	}

}
