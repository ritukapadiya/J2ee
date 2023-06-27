package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cookie = request.getParameter("cookieName");
		Cookie c[] = request.getCookies();
		for(Cookie n:c) {
			if(n.getName().equals(cookie)) {
				n.setMaxAge(0);
			   response.addCookie(n);
			   break;
			}
		}
		request.getRequestDispatcher("ListCookieServlet").forward(request, response);
	}

	

}
