package com.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about html page");
//		sending name html with thymleaf
		model.addAttribute("name", "swapnil Sunil hogade");
//		about html page	
		return "about";
	}

//	iterator handler
	@RequestMapping("/iterate")
	public String iterateHandler(Model m) {
		List<String> names = List.of("swapnil", "shree", "kailash");
		m.addAttribute("names", names);
		return "iterate";
	}

//	condition handler
	@RequestMapping("/condition")
	public String condition(Model m) {
		m.addAttribute("isActive", true);
		return "condition";
	}

//	include / insert handler in thymeleaf
	@RequestMapping("/service")
	public String service() {
		
		return "service";
	}
}
