package com.test.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.EmployeeInfo;
import com.test.entity.TimestampEntity;
import com.test.service.TimestampService;

@Controller
@RequestMapping("/time")
public class TimeStampCrud {
	@Autowired
	private TimestampService timestampService;

	@PostMapping
	public ResponseEntity<TimestampEntity> saveTimestamp(@RequestBody TimestampEntity timestampEntity) {
		return ResponseEntity.ok(timestampService.saveTimestamp(timestampEntity));
	}

	@GetMapping
	public ResponseEntity<List<TimestampEntity>> getAllTimestamps() {
		return ResponseEntity.ok(timestampService.getAllTimestamps());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<TimestampEntity> getTimestampById(@PathVariable Long id) {
		return ResponseEntity.ok(timestampService.getTimestampById(id));
	}

	@RequestMapping("/delete/{id}")
	public String deleteTimestamp(@PathVariable Long id, Model model) {
		timestampService.deleteTimestamp(id);

		// Add a confirmation message to the model
		model.addAttribute("confirmationMessage", "Timestamp with ID " + id + " deleted successfully!");

		// Return the name of the view to display
		return "deleteConfirmationEmployee";
	}

	@GetMapping("/{id}/duration")
	public String calculateDuration(@PathVariable Long id, Model model) {
		Duration duration = timestampService.calculateDuration(id);

		long hours = duration.toHours();
		long minutes = duration.toMinutesPart();
		long seconds = duration.toSecondsPart();

		String durationMessage = String.format("%d hours, %d minutes, %d seconds", hours, minutes, seconds);
		model.addAttribute("durationMessage", durationMessage);

		return "EmployeeWorkingHours";
	}

	@GetMapping("/attendence")
	public String profile(Model model) {
		List<TimestampEntity> employeeInfoList = timestampService.getAllData();
		System.out.println(employeeInfoList);
		model.addAttribute("employeeInfoList", employeeInfoList);
		return "attendenceApprove";
	}

	@GetMapping("/{id}/approve")
	public String approveTimestamp(@PathVariable Long id, Model model) {
		timestampService.approveTimestamp(id);

		// Set a model attribute for the alert message
		model.addAttribute("alertMessage", "Timestamp approved successfully!");

		// Return the view without redirection
		return "approvePage";
	}

}
