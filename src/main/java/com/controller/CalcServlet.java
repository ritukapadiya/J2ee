package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html");
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		
		String choice = req.getParameter("choice");
		
		PrintWriter out = res.getWriter();
		
		out.print("<html><body>");
		
		if(n1.equals("") || n2.equals("")) {
			out.print("<h1>Please enter the number.</h1>");
		}
		else {
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
		
			if(choice == null) {
				out.print("<h1>Please enter the choice for Calculation</h1>");
			}
			
			else {
				if(choice.equals("add")) {
					int s = num1+num2;
					out.print("Addition is: "+s);
				}
				else if(choice.equals("sub")){
					int s = num1-num2;
					out.print("Subtraction is: "+s);
				}
				else if(choice.equals("mul")) {
					int s = num1*num2;
					out.print("Multiplication is: "+s);
				}
				else if(choice.equals("div")) {
					int s = num1/num2;
					out.print("Divison is: "+s);
				} 
			}
		}
		out.print("</body></html>");
	}
}
