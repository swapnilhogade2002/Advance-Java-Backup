package com.test.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.test.dao.ContactRepository;
import com.test.dao.UserRepository;
import com.test.entities.Contact;
import com.test.entities.Message;
import com.test.entities.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;

//	uses for adding common data
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {

		String name = principal.getName();

		User user = userRepository.getUserByUsername(name);

		model.addAttribute("user", user);

	}

//	user home
	@RequestMapping("/index")
	public String userDashboard(Model model, Principal principal) {
		return "user/user-dashboard";
	}

//	form for adding user
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model) {
		model.addAttribute("title", "Add Contact Form");
		model.addAttribute("contact", new Contact());
		return "user/add-contact-form";
	}

	@PostMapping("/process-contact")
	public String saveContact(@Valid Contact contact, BindingResult result, @RequestParam("image") MultipartFile file,
			Model model, Principal principal, HttpSession session) {

		try {
			String name = principal.getName();
			User user = this.userRepository.getUserByUsername(name);
			contact.setUser(user);

			if (file.isEmpty()) {
				System.out.println("Select file ..It's empty!");
				contact.setImage("profile.png");
			} else {
				contact.setImage(file.getOriginalFilename());
				File saveFile = new ClassPathResource("static/img").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Image uploaded succesfully!!!");
			}

			user.getContacts().add(contact);
			this.userRepository.save(user);

			System.out.println("Successfully contact added!!!");
			System.out.println("Add contact Data " + contact);

			// sending message to url
			session.setAttribute("message", new Message("Your contact is added / updated!!...", "success"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

			session.setAttribute("message", new Message("Something went wrong...try again", "error"));
		}

		return "user/add-contact-form";
	}

	@GetMapping("/show-contact/{Page}")
	public String showContact(@PathVariable("Page") Integer page, Model m, Principal principal) {

		String userName = principal.getName();
		User user = this.userRepository.getUserByUsername(userName);

		PageRequest pageable = PageRequest.of(page, 5);
		Page<Contact> contacts = this.contactRepository.findContactByUser(user.getId(), pageable);
		m.addAttribute("contacts", contacts);

		m.addAttribute("contacts", contacts);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages", contacts.getTotalPages());

		return "user/show-contact";
	}

//	showing particular contact detail
	@RequestMapping("/contact/{cid}")
	public String showContactDetails(@PathVariable("cid") Integer cid, Model model, Principal principal) {
		System.out.println("Contact id " + cid);

		Optional<Contact> findContact = this.contactRepository.findById(cid);
		Contact contact = findContact.get();

		// solving security bug

		String name = principal.getName();
		User user = this.userRepository.getUserByUsername(name);

		if (user.getId() == contact.getUser().getId())
			model.addAttribute("contact", contact);

		return "user/contact-detail";
	}

//	deleting contact where we are showing this contact 
	@GetMapping("/delete/{cid}")
	public String deleteContact(@PathVariable("cid") Integer cId, Model model, HttpSession session) {

		Optional<Contact> contactOptional = this.contactRepository.findById(cId);
		Contact contact = contactOptional.get();

		// contact.setUser(null);
		this.contactRepository.delete(contact);
		System.out.println("Contact deleted!");

		session.setAttribute("message", new Message("contact deleted succesfully!!!", "success"));

		return "redirect:/user/show-contact/0";
	}

//	updating contact
	@PostMapping("/update-contact/{cid}")
	public String updateContact(@PathVariable("cid") Integer cid, Model m) {

		Contact contact = this.contactRepository.findById(cid).get();
		m.addAttribute("contact", contact);
		return "user/update-contact";
	}

//	handling update form request
	@PostMapping("/update-contact")
	public String saveUpdatedContact(@ModelAttribute("contact") Contact contact,
			@RequestParam("image") MultipartFile file, Principal principal) {
		try {

//			contact.setImage(file);

			User user = this.userRepository.getUserByUsername(principal.getName());
			contact.setUser(user);
			this.contactRepository.save(contact);

			return "redirect:/user/success-page";
		} catch (Exception e) {
			e.printStackTrace();
			// Redirect to an error page if there's an exception
			return "redirect:/user/error-page";
		}
	}

	
//	user profile 
	@RequestMapping("/profile")
	public String profileView() {
		return "user/user-profile";
	}

}
