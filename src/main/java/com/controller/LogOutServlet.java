package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		
		Cookie c[] = request.getCookies();
		for(Cookie x:c) {
			if(x.getName().equals("isLogIn")) {
				x.setMaxAge(0);
				response.addCookie(x);
			}
		}
		response.sendRedirect("LogIn.jsp");
	}
}
