package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.UserBean;
import com.dao.UserDao;
import com.util.DBConnection;
import com.util.Validators;
//@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Sign up Servlet");
	
		
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		
		boolean isError = false;
		String error = "";
		
		if(Validators.isBlank(fn)) {
			isError=true;
			error = error+ "First name is required<br>";
			request.setAttribute("firstNameError", "Firstname is required");
		}
		else {
			if(Validators.isAlpha(fn)) {
				request.setAttribute("firstNameValue", fn);
			}
			else {
				isError=true;
				request.setAttribute("firstNameError", "Firstname has alpha character only");
			}
		}
		if(Validators.isBlank(ln)) {
			isError=true;
			error = error+ "Last name is required<br>";
			request.setAttribute("lastNameError", "Lastname is required");
		}
		else {
			if(Validators.isAlpha(ln)) {
				request.setAttribute("lastNameValue", ln);
			}
			else {
				isError=true;
				request.setAttribute("lastNameError", "Lastname has alpha character only");
			}
		}
		if(Validators.isBlank(pass)) {
			isError=true;
			error= error+"Password is required<br>";
			request.setAttribute("passwordError", "Password is required");
		}
		else {
			request.setAttribute("passwordValue", pass);
		}
		if(Validators.isBlank(email)) {
			isError=true;
			error=error+"Email is required<br>";
			request.setAttribute("emailError", "Email is required");
		}
		else {
			if(Validators.isEmail(email)) {
				request.setAttribute("emailValue", email);
			}
			else {
				request.setAttribute("emailError", "Invalid format of email");

			}
		}
		if(isError == true) {
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("AddUser.jsp");
			rd.forward(request, response);
			
		}
		
		else if(isError == false){
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			
//			out.print("<html><body><h2>");
//			
//				out.print("First name: "+fn+"<br>");
//				out.print("Email: "+email+"<br>");
//				out.print("Password: "+pass+"<br>");
//				out.print("</h2></body></html>");
			 
			

			
			UserBean ub = new UserBean();
			ub.setFirstName(fn);
			ub.setLastName(ln);
			ub.setPassword(pass);
			ub.setEmail(email);
			
			UserDao ud = new UserDao();
			ud.insert(ub);
			
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		}
	
}
}
