package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.util.Validators;

public class AddProductFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String qty = request.getParameter("qty");
		
		boolean isError = false;
		
		if(Validators.isBlank(name)) {
			request.setAttribute("nameError", "Name is required");
			isError = true;
		}
		
		if(Validators.isBlank(price)) {
			request.setAttribute("priceError", "Price is required");
			isError = true;
		}
		else if(Validators.isDigit(price)==false) {
			request.setAttribute("priceError", "Price must be in digits");
			isError = true;
		}
		if(isError == true) {
			request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
		}
		else {
			chain.doFilter(request, response); // go to next filter
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
