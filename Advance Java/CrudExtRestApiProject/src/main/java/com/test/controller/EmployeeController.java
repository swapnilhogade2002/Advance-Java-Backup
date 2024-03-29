package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.model.Employee;
import com.test.service.EmployeeService;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        try {
            Employee[] employees = employeeService.fetchEmployeesFromApi();
            model.addAttribute("employees", employees);
        } catch (Exception e) {
            // Handle exceptions gracefully
            model.addAttribute("error", "An error occurred while fetching data from the external API.");
        }

        return "employeePage";
    }
}
