package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PriceFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		int price = Integer.parseInt(request.getParameter("price"));
		boolean isError = false;
		if(price < 500 || price > 100000) {
			request.setAttribute("priceError", "Price must be in range of (500,100000)");
			isError = true;
		}
		if(isError==true) {
			request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
		}
		else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
