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


}
