package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Sign up Servlet");
		
		
		
		String fn = req.getParameter("fn");
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");
		String gender = req.getParameter("gen");
		String con = req.getParameter("country");
		String hby[]=req.getParameterValues("hby");
		String allHby = "";
		boolean isError = false;
		String error = "";
		
		
//		out.print(hby.length);
		if(fn == null || fn.trim().length()==0) {
			isError=true;
			error = error+ "First name is required<br>";
		}
		if(pass == null || pass.trim().length()==0) {
			isError=true;
			error= error+"Password is required<br>";
		}
		if(email == null || email.trim().length()==0) {
			isError=true;
			error=error+"Email is required<br>";
		}
		if(gender == null) {
			isError=true;
			error=error+"Gender is required<br>";
		}
		if(con.equals("none")) {
			isError=true;
			error=error+"Country is required<br>";
		}
		if(hby == null || hby.length == 0) {
			isError=true;
			error=error+"Hobby is required<br>";
		}
		if(isError == true) {
//			out.print("<font color='red'>"+error+"</font>");
			RequestDispatcher rd = req.getRequestDispatcher("SignUp.html");
			rd.forward(req, resp);

		}
		
		else if(isError == false){
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			out.print("<html><body><h2>");
				out.print("First name: "+fn+"<br>");
				out.print("Email: "+email+"<br>");
				out.print("Password: "+pass+"<br>");
				
		//		gender
				if(gender.equals("f")) {
					out.print("Gender: Female" +"<br>");
				}
				else if(gender.equals("m")){
					out.print("Gender: Male" +"<br>");
				}
				
		//		hobby
				for(int i=0;i<hby.length;i++) {
					if(hby[i].equals("dance")) {
						allHby = allHby + " Dance";
					}
					else if(hby[i].equals("basketball")) {
						allHby = allHby + " Basketball";
					}
					
					else if(hby[i].equals("singing")) {
						allHby = allHby + " Singing";
					}
					else if(hby[i].equals("learning")) {
						allHby = allHby + " Learning";
					}
				}
				out.print("Hobby: "+allHby+"<br>");
		
				//		country
				if(con.equals("in")) {
					out.print("Country: India"+"<br>");
				}
				else if(con.equals("us")) {
					out.print("Country: USA"+"<br>");
				}
				else if(con.equals("ge")) {
					out.print("Country: Germany"+"<br>");
				}
				else if(con.equals("ca")) {
					out.print("Country: Canada"+"<br>");
				}
				else if(con.equals("ch")) {
					out.print("Country: China"+"<br>");
				}
				out.print("</h2></body></html>");
		}
	
}
}
