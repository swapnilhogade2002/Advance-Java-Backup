package springmvc.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.dao.ProductDao;
import springmvc.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/index")
	public String Home(Model m) {

		List<Product> products = productDao.getProducts();
		m.addAttribute("products", products);
		return "index";
	}

//	add product
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add-product-form";
	}

//	handling add product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public String handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl(request.getContextPath()+"/index");
		return "redirect:/index";
	}

//	delete product
	@RequestMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, RedirectAttributes attributes) {
		this.productDao.deleteProduct(productId);
		attributes.addFlashAttribute("message", "Product deleted successfully!");
		return "redirect:/index";
	}

//	update product
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int pid, Model model) {
		Product product = this.productDao.getProduct(pid);
		model.addAttribute("product", product);
		System.out.println(product);
		return "update-form";

	}

//	view product
	@RequestMapping("/view/{productId}")
	public String viewProduct(@PathVariable("productId") int productId, Model model) {
		// Retrieve the product details from the database using the productId
		Product product = productDao.getProduct(productId);

		// Add the product details to the model
		model.addAttribute("product", product);

		// Return the view details page
		return "viewProduct";
	}

//	logout session management
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidate the session
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// Set cache-control headers to prevent caching
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		// Redirect to the login page
		return "redirect:/loginpage";
	}

}
