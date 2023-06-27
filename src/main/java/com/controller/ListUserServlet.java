package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.DBConnection;

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		UserDao userDao = new UserDao();
		ArrayList<UserBean> userList= userDao.displayData();
		if(userList != null) {
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("ListUser.jsp").forward(request, response);
		}
			
		}
	}

