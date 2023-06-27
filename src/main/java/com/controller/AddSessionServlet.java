package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.Validators;

public class AddSessionServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email =  request.getParameter("sessionName");
		String password = request.getParameter("sessionValue");
		
		HttpSession session = request.getSession();
		
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
			session.setAttribute("email",email);
			session.setMaxInactiveInterval(60*10); // globally we can done in web.xml
			request.setAttribute("email", email);
			request.getRequestDispatcher("ListSession.jsp").forward(request, response);
			
		}
		
		else {
			request.setAttribute("error", "Invalid data");
			request.getRequestDispatcher("AddSession.jsp").forward(request, response);
		}
		
		
	}

}
