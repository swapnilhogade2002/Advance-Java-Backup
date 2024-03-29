package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// Establish a database connection
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shree", "root", "mysql@2002");

			// Prepare and execute the SQL insert statement
			String sql = "INSERT INTO user (fname, lname, pass, email,phone) VALUES (?, ?, ?, ?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, pass);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.executeUpdate();

			// Redirect to a success page or do further processing
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			// Handle any errors and redirect to an error page
			response.sendRedirect("error.jsp");
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
