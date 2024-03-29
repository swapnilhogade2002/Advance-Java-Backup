package com.swapnil;

@Controller
public class AddController {
	@RequestMapping("/add")

	public String add() {
		return "Display.jsp";
	}
	/*
	 * public ModalAndView add(HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * int i = Integer.parseInt(request.getParameter("t1")); int j =
	 * Integer.parseInt(request.getParameter("t2")); int k = i+j;
	 * 
	 * ModalAndView mv = new ModalAndView(); mv.setViewName("Display.jsp");
	 * mv.addObject("result",k)
	 * 
	 * 
	 * return mv; // Assuming "Display.jsp" is the name of the view }
	 */
}
