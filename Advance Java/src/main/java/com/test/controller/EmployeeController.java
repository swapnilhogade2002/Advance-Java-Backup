package com.test.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.entity.Employee;
import com.test.entity.EmployeeAttendance;
import com.test.entity.EmployeeInfo;
import com.test.repository.EmployeeInfoRepo;
import com.test.repository.EmployeeRepo;
import com.test.service.EmployeeAttendanceService;
import com.test.service.EmployeeInfoService;
import com.test.service.EmployeeService;
import com.test.service.EmployeeServiceImpl;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	@Autowired
	private EmployeeInfoRepo employeeInfoRepo;

	@Autowired
	private EmployeeInfoService employeeInfoService;

	@Autowired
	private EmployeeAttendanceService employeeAttendanceService;

//	@Autowired
//	private PunchService punchService;

	@ModelAttribute
	public void commanUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			Employee employee = employeeRepo.findByEmail(email);
			m.addAttribute("employee", employee);

		}
	}

//	@GetMapping("/profile")
//	public String profile() {
//		return "profile";
//	}

	@GetMapping("/profile")
	public String showProfile(Model model, Principal principal) {
// 		Assuming you have an Employee object in your application
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

//		dynamic email
		String email = principal.getName();
		model.addAttribute("email", email);
		Employee employees = this.employeeService.getEmployeeByname(email);

		model.addAttribute("employees", employees);

		System.out.println("email: " + email);

		return "profile";
	}

//	add employee
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("EmployeeInfo", new EmployeeInfo());
		return "employeeForm";
	}

	@PostMapping("/form")
	public String submitForm(@Valid @ModelAttribute EmployeeInfo employee) {
		employeeInfoRepo.save(employee);
		return "redirect:/employee/profile";
	}

//	punch service
//	@PostMapping("/punch")
//	public String punch(@RequestParam("userId") Long userId, @RequestParam("action") String action) {
//		if ("punchIn".equals(action)) {
//			punchService.punchIn(userId);
//		} else if ("punchOut".equals(action)) {
//			punchService.punchOut(userId);
//		}
//
//		// Redirect to the employee page or another appropriate page
//		return "redirect:/employee/profile";
//	}

//	add employee
	@GetMapping("/attendence")
	public String employeeAttendence(Model model, Principal principal) {
		model.addAttribute("EmployeeInfo", new EmployeeInfo());

//		dynamic email
		String email = principal.getName();
		model.addAttribute("email", email);
		Employee employees = this.employeeService.getEmployeeByname(email);

		model.addAttribute("employees", employees);

		System.out.println("email: " + email);
		return "attendence1";
	}

//	attendence status
	@GetMapping("/attendenceStatus")
	public String employeeAttendenceStatus(Model model, Principal principal) {
		List<EmployeeAttendance> employeeAttendanceList = employeeAttendanceService.getAllEmployeeAttendance();
		model.addAttribute("employeeAttendanceList", employeeAttendanceList);
		return "attendenceStatus";
	}

	@GetMapping("/search-attendance/{employeeId}")
	public String searchAttendance(@PathVariable String employeeId, Model model) {
		// Perform the search based on the provided employeeId
		List<EmployeeAttendance> employeeAttendanceList = employeeAttendanceService.findByEmployeeId(employeeId);

		// Add the search results to the model
		model.addAttribute("employeeAttendanceList", employeeAttendanceList);

		// Return the view to display the search results
		return "EmployeeAttendenceView";
	}

}
