<%@page import="com.service.MailService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Something went wrong. Please try after sometime...</h1>
	<%="Exception: "+exception %><br><br>
	<%="Class: "+ exception.getClass() %> <br><br>
	<%="Message: "+ exception.getMessage() %> <br><br>
	
    <%
    	MailService m = new MailService();
			m.sendMailForError("ritukapadiya2002@gmail.com", exception); //devloper email or might be have array of dev. emails
    %>
</body>
</html>