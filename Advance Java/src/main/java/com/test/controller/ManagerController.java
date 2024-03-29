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

import com.test.entity.Employee;
import com.test.entity.EmployeeInfo;
import com.test.repository.EmployeeInfoRepo;
import com.test.repository.EmployeeRepo;
import com.test.service.EmployeeInfoService;
import com.test.service.EmployeeService;
import com.test.service.EmployeeServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private EmployeeInfoService employeeInfoService;

	@Autowired
	private EmployeeInfoRepo employeeInfoRepo;

	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute
	public void commanUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			Employee employee = employeeRepo.findByEmail(email);
			m.addAttribute("employee", employee);

		}
	}

	// UI data
//	@GetMapping("/view")
//	public String listEmployeeInfos(Model model) {
//		List<EmployeeInfo> employeeInfoList = employeeInfoService.getAllEmployee();
//		System.out.println(employeeInfoList);
//		model.addAttribute("employeeInfoList", employeeInfoList);
//		return "manager-profile";
//	}

	@GetMapping("/profile")
	public String profile(Model model) {
//		
		List<EmployeeInfo> employeeInfoList = employeeInfoService.getAllEmployee();
		System.out.println(employeeInfoList);

//		total employee
		long totalEmployees = employeeInfoService.getTotalCount();
		model.addAttribute("totalEmployees", totalEmployees);
		model.addAttribute("employeeInfoList", employeeInfoList);

//	    total male employee
		long totalMaleEmployees = employeeInfoService.getCountByGender("Male");
		model.addAttribute("totalMaleEmployees", totalMaleEmployees);

//		total female employee
		long totalFemaleEmployee = employeeInfoService.getCountByGender("Female");
		model.addAttribute("totalFemaleEmployee", totalFemaleEmployee);

//		total married employee
		long totalMarriedEmployee = employeeInfoService.getCountByMaritalStatus("Married");
		model.addAttribute("totalMarriedEmployee", totalMarriedEmployee);

//		total single employee
		long totalSingleEmployee = employeeInfoService.getCountByMaritalStatus("Single");
		model.addAttribute("totalSingleEmployee", totalSingleEmployee);

//		employee education level -bachelor
		long totalEmployeeBachelor = employeeInfoService.getCountByEducationLevel("Bachelor's Degree");
		model.addAttribute("totalEmployeeBachelor", totalEmployeeBachelor);

//		employee education level -bachelor
		long totalEmployeeMaster = employeeInfoService.getCountByEducationLevel("Master's Degree");
		model.addAttribute("totalEmployeeMaster", totalEmployeeMaster);

		return "manager-profile";

	}

//	download

//  download pdf
	@GetMapping
	public List<Employee> getAllEntities() {
		return employeeServiceImpl.getAllEntities();
	}

	@GetMapping("/download")
	public void downloadEntities(HttpServletResponse response) throws IOException {
		List<Employee> entities = employeeServiceImpl.getAllEntities();

		// Set the content type and headers for the response
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=entities.csv");

		// Write the data to the response output stream
		// You can use a library like OpenCSV for better CSV handling
		for (Employee entity : entities) {
			response.getWriter().write(entity.toString()); // Customize based on your entity structure
			response.getWriter().write("\n");
		}
	}

//	edit employee data link on manager ui 
	@GetMapping("/editEmployeeData")
	public String editEmployeeData() {
		return "editEmployeeData";
	}

//	CRUD of Attendence by manager
	@GetMapping("/editAttendenceData")
	public String attendenceApproveManager() {
		return "attendenceApproveByManager";
	}
//	CRUD on manager UI

////	add employee
//	@GetMapping("/form")
//	public String showForm(Model model) {
//		model.addAttribute("EmployeeInfo", new EmployeeInfo());
//		return "employeeForm";
//	}
//
//	@PostMapping("/form")
//	public String submitForm(@ModelAttribute EmployeeInfo employee) {
//		employeeInfoRepo.save(employee);
//		return "redirect:/manager/profile";
//	}

//	edit
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id, Model model) {
		EmployeeInfo employeeInfo = employeeInfoService.getEmployeeInfo(id);
		model.addAttribute("EmployeeInfo", employeeInfo);
		return "employeeEditForm";
	}

	@PostMapping("/edit")
	public String submitEditForm(@ModelAttribute EmployeeInfo employee) {
		employeeInfoService.saveEmployeeInfo(employee);
		return "redirect:/manager/profile";
	}

//	delete
	@GetMapping("/delete/{id}")
	public String deleteEmployeeInfo(@PathVariable Long id) {
		employeeInfoService.deleteEmployeeInfo(id);
		return "redirect:/manager/profile";
	}

//	view 
	@GetMapping("/view/{id}")
	public String viewEmployeeInfo(@PathVariable Long id, Model model) {
		EmployeeInfo employeeInfo = employeeInfoService.getEmployeeInfo(id);
		model.addAttribute("EmployeeInfo", employeeInfo);
		return "employeeView";
	}

	@GetMapping("/editManagerData")
	public String editManagerData(Model model) {
//		
		List<EmployeeInfo> employeeInfoList = employeeInfoService.getAllEmployee();
		System.out.println(employeeInfoList);
		model.addAttribute("employeeInfoList", employeeInfoList);
		return "editEmployeeData";
	}

//	manager attendence
	@GetMapping("/attendence1")
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

}
