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
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.Todo;
import com.test.service.PostService;

// EnggAdda Yt

@Controller
@RequestMapping("/client")
public class PostController {

	@Autowired
	private PostService postService;

	// Show data
	@GetMapping(produces = "application/json")
	private String showData(Model model) {
		List<Todo> todos = postService.showData();
		model.addAttribute("todos", todos);
		return "showData";
	}

	// Show particular id
	@GetMapping("/{taskId}")
	private String showParticularData(@PathVariable int taskId, Model model) {
		Todo todo = postService.showParticularData(taskId);
		model.addAttribute("todo", todo);
		return "showParticularData";
	}

	// Create new data
//	@GetMapping("/new")
//	private String createNewDataForm(Model model) {
//		model.addAttribute("newTodo", new Todo());
//		return "createNewData";
//	}

	@GetMapping("/new")
	private String createNewDataForm(Model model) {
		Todo newTodo = new Todo(); // Create a new Todo object
		model.addAttribute("newTodo", newTodo);
		return "createNewData";
	}

	@PostMapping("/new")
	private String createNewData(@ModelAttribute("newTodo") Todo newTodo) {
		postService.createNewData(newTodo);
		return "redirect:/client";
	}

	// edit data
	@GetMapping("/edit/{taskId}")
	private String updateDataForm(@PathVariable int taskId, Model model) {
		Todo todo = postService.showParticularData(taskId);
		model.addAttribute("todo", todo);
		return "updateData";
	}

	@PostMapping("/edit/{taskId}")
	private String updateData(@PathVariable int taskId, @ModelAttribute("todo") Todo todo) {
		System.out.println("Updating data for taskId: " + taskId);
		postService.updateData(taskId, todo);
		return "redirect:/client";
	}

	// Delete data
	@GetMapping("/delete/{taskId}")
	private String deleteData(@PathVariable int taskId) {
		postService.deleteData(taskId);
		return "redirect:/client";

	}

//	data search
	@GetMapping("/search")
	private String searchByTitle(@RequestParam String query, Model model) {
		List<Todo> todos = postService.searchByTitle(query);
		model.addAttribute("todos", todos);
		return "showData"; // Make sure this is the correct template name
	}
}
//
//	@GetMapping("/hello")
//	public String Hello() {
//		return "hello world";
//	}
//
////	show data
//	@RequestMapping(value = "/client", method = RequestMethod.GET)
//	private String showData() {
//		String url = "https://jsonplaceholder.typicode.com/todos";
//		RestTemplate restTemplate = new RestTemplate();
//		String res = restTemplate.getForObject(url, String.class);
//		return res;
//
//	}
//
////	show particular id
//	@RequestMapping(value = "/client/{taskId}", method = RequestMethod.GET)
//	private String showParticularData() {
//		String url = "https://jsonplaceholder.typicode.com/todos/{taskId}";
//		RestTemplate restTemplate = new RestTemplate();
//		String res = restTemplate.getForObject(url, String.class);
//		return res;
//	}
//
////	create new data	
//	@RequestMapping(value = "/client", method = RequestMethod.POST)
//	private String createNewData() {
//		String url = " https://jsonplaceholder.typicode.com/todos";
//		RestTemplate restTemplate = new RestTemplate();
//		String res = restTemplate.getForObject(url, String.class);
//		return res;
//	}
//
////	update data
//	@RequestMapping(value = "/client/{taskId}", method = RequestMethod.PUT)
//	private String updateData() {
//		String url = " https://jsonplaceholder.typicode.com/todos/{taskId}";
//		RestTemplate restTemplate = new RestTemplate();
//		String res = restTemplate.getForObject(url, String.class);
//		return res;
//	}
//
////	delete data
//	@RequestMapping(value = "/client/{taskId}", method = RequestMethod.DELETE)
//	private String deleteData() {
//		String url = " https://jsonplaceholder.typicode.com/todos/{taskId}";
//		RestTemplate restTemplate = new RestTemplate();
//		String res = restTemplate.getForObject(url, String.class);
//		return res;
//	}

//@RestController
//@RequestMapping("/api")
//public class PostController {
//	
//	@Autowired
//	private PostService postService;
//	
//	@GetMapping("/getPosts")
//	List<Map<String, Object>> getPosts(){
//		return postService.getPosts();
//		
//	}
//}
