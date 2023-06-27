package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.Validators;
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(Validators.isBlank(email)) {
			request.setAttribute("emailError", "email is required");
		}
		if(Validators.isBlank(password)) {
			request.setAttribute("passwordError", "password is required");
		}
		
		UserBean setUserBean = new UserBean();
		setUserBean.setEmail(email);
		setUserBean.setPassword(password);
		
		UserDao userDao = new UserDao();
		UserBean getUserBean = userDao.checkData(setUserBean);
		if(getUserBean != null) {
			Cookie cookie = new Cookie("isLogIn","true");
//			cookie.setHttpOnly(true);
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
			
			request.setAttribute("name", getUserBean.getFirstName());
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
//			response.sendRedirect("Dashboard.jsp");
			
		}
		
		else {
			request.setAttribute("error", "Invalid data");
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		}
	}
}
//-------------------------------------------------------------------------------
//Login.jsp > email password -> LoginServlet -> read authenticate ->  true -> {cookie:islogin:true } Home.jsp 
//browser close 
//open -> Home.jsp -> it will open -> click on logout link -> Login.jsp 
//browser close 
//open -> Home.jsp -> it will not open -> redirec Login.jsp 
//h o p madd 
//---------------------------------------------------------------------------------
//req -> filter | home.jsp