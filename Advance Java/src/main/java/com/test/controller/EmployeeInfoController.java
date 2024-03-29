package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.EmployeeInfo;
import com.test.repository.EmployeeInfoRepo;
import com.test.service.EmployeeInfoService;
import com.test.service.EmployeeInfoServiceImpl;

@Controller
@RequestMapping("/employeeform")
public class EmployeeInfoController {

	@Autowired
	private EmployeeInfoRepo employeeInfoRepo;

	@Autowired
	private EmployeeInfoService employeeInfoService;


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
//		return "redirect:/employee/profile";
//	}
//
////	edit
//	@GetMapping("/edit/{id}")
//	public String editForm(@PathVariable Long id, Model model) {
//		EmployeeInfo employeeInfo = employeeInfoService.getEmployeeInfo(id);
//		model.addAttribute("EmployeeInfo", employeeInfo);
//		return "employeeEditForm";
//	}
//
//	@PostMapping("/edit")
//	public String submitEditForm(@ModelAttribute EmployeeInfo employee) {
//		employeeInfoService.saveEmployeeInfo(employee);
//		return "redirect:/employee/profile";
//	}
//
////	delete
//	@GetMapping("/delete/{id}")
//	public String deleteEmployeeInfo(@PathVariable Long id) {
//		employeeInfoService.deleteEmployeeInfo(id);
//		return "redirect:/employeeform/form";
//	}
//
////	view 
//	@GetMapping("/view/{id}")
//	public String viewEmployeeInfo(@PathVariable Long id, Model model) {
//		EmployeeInfo employeeInfo = employeeInfoService.getEmployeeInfo(id);
//		model.addAttribute("EmployeeInfo", employeeInfo);
//		return "employeeView";
//	}

}
