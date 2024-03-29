package com.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.entities.LoginData;

@Controller
public class MyController {
	@GetMapping("/form")
	public String openForm(Model m) {
		System.out.println("into form");
		m.addAttribute("loginData", new LoginData());
		return "validate";
	}

//	form handler
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult results) {
		System.out.println(results);
		if (results.hasErrors()) {
			System.out.println(results);
			return "validate";
		}
		System.out.println(loginData);
		return "success";
	}
}
