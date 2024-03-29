package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.dao.UserRepository;
import com.test.entities.Message;
import com.test.entities.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/login")
	public String login() {
		return "loginPage";
	}

	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result1,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {

		try {
			if (!agreement) {
				System.out.println("You are not agree to agrrement !");
				throw new Exception("You are not agree to agrrement !");
			}

			if (result1.hasErrors()) {
				System.out.println("Error " + result1.toString());
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.img");
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			User result = userRepository.save(user);

			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registerd", "alert-success"));
			System.out.println("Reistration succesfully!!!");

			System.out.println("Agreement" + agreement);
			System.out.println("User" + user);
			return "signup";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("something went wrong" + e.getMessage(), "alert-danger"));
			return "loginPage";
		}

	}

	

	@RequestMapping("/logout")
	public String logout() {
		return "signin";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "signup";
	}

}
