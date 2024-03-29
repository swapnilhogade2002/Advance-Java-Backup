package com.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		/* dao class which check data from database */
		LoginDao dao = new LoginDao();

		try {
			if (dao.check(email, pass)) {
				/* session stored value and check it */
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("welcome.jsp");
			}

			else {
				 HttpSession m = request.getSession(); 
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
