package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import springmvc.model.User;

@Controller
public class FormController {
	public String openForm(Model model) {
		System.out.println("opening register form");
		model.addAttribute("regData", new User());
		
		return("register");
	}
}
