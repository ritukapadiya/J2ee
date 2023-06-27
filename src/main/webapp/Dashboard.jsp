<%@page import="com.listener.UserCountListener"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Welcome ${name}</h1>
	Number of users are online: <%= UserCountListener.count %> <br><br>
	<a href="ListUserServlet">List of users</a>
	<a href="LogOutServlet">log out</a>
	
</body>
</html>