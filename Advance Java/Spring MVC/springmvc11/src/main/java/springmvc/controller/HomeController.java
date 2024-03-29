package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.dao.LoginDao;
import springmvc.dao.UserDao;

//@Controller
//public class HomeController {
//
//	@RequestMapping("/home")
//	public String home(Model model) {
//		System.out.println("home url working");
////	sending data from controller to view
//		model.addAttribute("name","swapnil hogade");
//		return "home";
//	}
//
//	@RequestMapping("/about")
//	public String about() {
//		System.out.println("about url working");
//		return "about";
//	}
//	
//	@RequestMapping("/help")
//	public ModelAndView help() {
//		System.out.println("help");
//		ModelAndView  modelAndView = new  ModelAndView();
//		modelAndView.addObject("name", "swapnil");
//		modelAndView.setViewName("help");
//		
//		return modelAndView;
//	}
//	
//	login mapping
//	@RequestMapping(path="/login" ,method=RequestMethod.POST)
//	public String login(@RequestParam("email") String em, @RequestParam("password") String pwd) {
//	LoginDao.loginUser();
//		
//		return "redirect:/login";
//		
//	}
//}
