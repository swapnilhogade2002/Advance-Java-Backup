package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.TimestampEntity;
import com.test.service.TimestampService;

@Controller
@RequestMapping("/punch")
public class TimestampController {

	@Autowired
	private TimestampService timestampService;

	    @PostMapping
	    public void punch(@RequestParam String userId, @RequestParam String action) {
	        if ("in".equals(action)) {
	        	timestampService.punchIn(userId);
	        } else if ("out".equals(action)) {
	        	timestampService.punchOut(userId);
	        }
	    }
	    
	    @GetMapping("/profile")
	    public String profile(Model model) {
	        List<TimestampEntity> timestampEntityList = timestampService.getAllData();
	        model.addAttribute("timestampEntityList", timestampEntityList);
	        return "attendenceApprove";
	    }    
}
