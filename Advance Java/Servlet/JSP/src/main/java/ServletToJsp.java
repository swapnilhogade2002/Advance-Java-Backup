import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletToJsp")
public class ServletToJsp extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = "swapnil";

		req.setAttribute("label", name);
		RequestDispatcher rd = req.getRequestDispatcher("ServletToJsp.jsp");
		rd.forward(req, res);
	}


}
