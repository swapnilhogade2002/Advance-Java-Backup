package springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class RegisterController {

	@Autowired(required = true)
	private UserService userService;

//	@ModelAttribute
//	public void coomonDataJsp(Model m) {
//		m.addAttribute("h", "swapnil hogade");
//
//	}

//	showing login page
	@RequestMapping("/loginpage")
	public String shoeLoginPage() {
		return ("loginpage");
	}

	@RequestMapping("/register")
	public String showForm() {
		return ("register");
	}

	@RequestMapping("/success")
	public String showSucess() {
		return ("success");
	}

//	use of modelattribute very easy just pass obj
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@Valid @ModelAttribute("user") User user, Model model, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result);
		}
		this.userService.createUser(user);
		System.out.println(user);
		return ("loginpage");
	}

	@RequestMapping(path = "/userlogin", method = RequestMethod.POST)
	public String loginpage(@RequestParam("email") String em, @RequestParam("password") String pwd,
			HttpSession session) {
		System.out.println("hello login");

		User user = this.userService.showLogin(em, pwd);
		System.out.println(user);

		if (user != null) {
			session.setAttribute("loginuser", user);
			return "redirect:/index";
		} else {
			session.setAttribute("msg", "invalid email and password");
			return "redirect:/loginpage";
		}
	}
}

/*
 * 
 * @Controller public class RegisterController {
 * 
 * @RequestMapping("/register") public String showForm() {
 * 
 * return ("register"); }
 * 
 * @RequestMapping(path="/processform",method = RequestMethod.POST) public
 * String handleForm(
 * 
 * @RequestParam("email") String email,
 * 
 * @RequestParam("userName") String userName,
 * 
 * @RequestParam("password") String password , Model model ) { // //
 * System.out.println(email); // System.out.println(userName); //
 * System.out.println(password);
 * 
 * User user = new User(); user.setEmail(email); user.setPassword(password);
 * user.setUserName(userName);
 * 
 * model.addAttribute("user", user);
 * 
 * // model.addAttribute("name", userName); // model.addAttribute("password",
 * password); // model.addAttribute("email", email);
 * 
 * return("sucess"); }
 * 
 * 
 * }
 */
