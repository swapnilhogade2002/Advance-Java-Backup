package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/demo")
	@ResponseBody
	public String test() {
		int a = 988;
		int b = 9;
		return "success" + (a + b);
	}

}
