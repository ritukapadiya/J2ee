package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) // <a> method get
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.viewUser(userId);
		
//		request.setAttribute("firstName", userBean.getFirstName());
//		request.setAttribute("lastName", userBean.getLastName());
//		request.setAttribute("password", userBean.getPassword());
		request.setAttribute("userBean", userBean);
		request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) // submit method post as mention in form
			throws ServletException, IOException {
		String emailUserId = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		
	   UserBean userBean = new UserBean();
	   userBean.setFirstName(firstName);
	   userBean.setLastName(lastName);
	   userBean.setPassword(password);
	   userBean.setEmail(emailUserId);
	   
	   UserDao userDao=new UserDao();
	   userDao.UpdateUser(userBean);
	   request.getRequestDispatcher("ListUserServlet").forward(request, response);
	}
}
