package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		
		UserDao userDao = new UserDao();
		userDao.deleteUser(userId);
		request.getRequestDispatcher("ListUserServlet").forward(request, response);
	}
}
