package com.sts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String Home() {
		System.out.println("home page");
		return("/home");
	}

}
