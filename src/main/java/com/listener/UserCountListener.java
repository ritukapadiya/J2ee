package com.listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserCountListener implements HttpSessionListener{
	public static int count = 0;
	public void sessionCreated(HttpSessionEvent se) {

		count++;
		System.out.println("IN: "+count);
			
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		count--;
		System.out.println("OUT: "+count);
	}

}
