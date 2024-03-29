package com.swapnil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sqareServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		
		PrintWriter out = res.getWriter();
		 out.println("hello from squre");
		 
//		 
//		 PrintWriter out = res.getWriter();
			out.print("hi");

			ServletContext ctx = getServletContext();
			String str = ctx.getInitParameter("mobile");
			out.println(str);
	}

}
