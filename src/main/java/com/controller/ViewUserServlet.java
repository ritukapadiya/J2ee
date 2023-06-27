package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.viewUser(userId);
		if(userBean!=null) {
			request.setAttribute("firstName", userBean.getFirstName());
			request.setAttribute("lastName", userBean.getLastName());
			request.setAttribute("email", userBean.getEmail());
			request.setAttribute("password", userBean.getPassword());
			request.getRequestDispatcher("ViewUser.jsp").forward(request, response);
		}
		
		
	}
}