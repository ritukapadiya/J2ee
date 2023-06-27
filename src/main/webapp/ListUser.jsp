<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of users</h1>
<%
ArrayList<UserBean> userList = (ArrayList) request.getAttribute("userList");
%>
	<table border='1'>
		<thead>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>EmailName</th>
				<th>Password</th>
				<th>Action </th>
			</tr>
		</thead>
		<tbody>
		<% for(UserBean userBean: userList){ %>
			<tr>
				<td> <%= userBean.getFirstName() %> </td>
				<td> <%= userBean.getLastName() %> </td>
				<td> <%= userBean.getEmail() %> </td>
				<td> <%= userBean.getPassword() %> </td>
				<td> <a href="DeleteUserServlet?userId=<%= userBean.getEmail() %>" >Delete </a> 
				     <a href="ViewUserServlet?userId=<%= userBean.getEmail() %>" >View</a>
				     <a href="UpdateUserServlet?userId=<%= userBean.getEmail() %>" >Edit</a></td>  
			</tr>
		<% } %>
		</tbody>
	</table>
</body>
</html>