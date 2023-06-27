package com.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet {
	
	String adminEmail = "";
	String adminPassword = "";
	
	String gEmail = "";
	String gPassword = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		adminEmail = config.getInitParameter("email");
		adminPassword = config.getInitParameter("password");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ServletContext context =  	request.getServletContext();
		gEmail = context.getInitParameter("globalEmail");
		gPassword = context.getInitParameter("globalPassword");	
		
		
		if((email.equals(adminEmail) && password.equals(adminPassword)) || (email.equals(gEmail) && password.equals(gPassword)) )
		{
			response.sendRedirect("AdminHome.jsp");
		}
		else {
			response.sendRedirect("AdminLogin.jsp");
		}

}
}
