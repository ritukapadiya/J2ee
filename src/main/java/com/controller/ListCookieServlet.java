package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ListCookieServlet")
public class ListCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie c[] = request.getCookies(); 
	
		
		request.setAttribute("allCookie",c);
		
		request.getRequestDispatcher("ListCookie.jsp").forward(request, response);
	}

}
