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
	    
	    
		/*
		 * @PostMapping public ResponseEntity<String> punch(@RequestParam String action)
		 * { if ("in".equals(action)) { // Handle Punch In logic lastPunchInTime =
		 * LocalDateTime.now(); return ResponseEntity.ok("Punched In successfully."); }
		 * else if ("out".equals(action)) { // Handle Punch Out logic if
		 * (lastPunchInTime != null &&
		 * lastPunchInTime.plusMinutes(2).isBefore(LocalDateTime.now())) { // Allow
		 * Punch Out if at least 2 minutes have passed since the last Punch In return
		 * ResponseEntity.ok("Punched Out successfully."); } else { // Respond with an
		 * error message or appropriate status return
		 * ResponseEntity.status(HttpStatus.BAD_REQUEST).
		 * body("Cannot Punch Out before 2 minutes."); } } else { // Handle other
		 * actions or respond with an error return
		 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid action."); } }
		 */
	    
	    @GetMapping("/profile")
	    public String profile(Model model) {
	        List<TimestampEntity> timestampEntityList = timestampService.getAllData();
	        model.addAttribute("timestampEntityList", timestampEntityList);
	        return "attendenceApprove";
	    }    
}
