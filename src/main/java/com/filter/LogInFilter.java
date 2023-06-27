package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/LogInFilter")
public class LogInFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginCheckFilter...");
		HttpServletRequest req = ((HttpServletRequest) request);
		HttpServletResponse res = ((HttpServletResponse) response);
		Cookie c[] = req.getCookies();

		boolean isLoin = false;
		if (req.getRequestURL().toString().contains("LogIn.jsp")) {
			for (Cookie x : c) {
				if (x.getName().equals("isLogIn")) {
					if (x.getValue().equals("true")) {
						// request.getRequestDispatcher("Dashboard.jsp").forward(request, response);

						isLoin = true;

						break;
					}
				}
			}
			if (isLoin == true) {
				res.sendRedirect("Dashboard.jsp");
			} else {
				chain.doFilter(request, response);
			}
			
			
		} else {

			isLoin = false;
			if (!req.getRequestURL().toString().contains("LogIn.jsp")
					&& !req.getRequestURL().toString().contains("LogInServlet")) {

				for (Cookie x : c) {
					if (x.getName().equals("isLogIn")) {
						if (x.getValue().equals("true")) {
							// request.getRequestDispatcher("Dashboard.jsp").forward(request, response);

							isLoin = true;

							break;
						}
					}
				}

				if (isLoin == true) {
					chain.doFilter(request, response);
				} else {
					res.sendRedirect("LogIn.jsp");
				}
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	// login -> isLogin present -> dashboard
	// any.jsp -> login must

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
}
