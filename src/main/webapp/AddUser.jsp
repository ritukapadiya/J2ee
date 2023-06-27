<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String error = (String)request.getAttribute("error");
String firstNameError = (String)request.getAttribute("firstNameError");
String lastNameError = (String)request.getAttribute("lastNameError");
String passwordError = (String)request.getAttribute("passwordError");
String emailError = (String)request.getAttribute("emailError");

String firstNameValue = (String)request.getAttribute("firstNameValue");
String lastNameValue = (String)request.getAttribute("lastNameValue");
String passwordValue = (String)request.getAttribute("passwordValue");
String emailValue = (String)request.getAttribute("emailValue");
%>
<h1>Sign Up page</h1>
	<form action="AddUserServlet" method="post">
		<table>
		<tr>
			<td>First Name :</td>
			<td><input type="text" name="fn" value="<%=firstNameValue==null?"":firstNameValue%>">
				<font color="red"><%=firstNameError==null?"":firstNameError %></font></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><input type="text" name="ln" value="<%=lastNameValue==null?"":lastNameValue%>">
				<font color="red"><%=lastNameError==null?"":lastNameError %></font></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="pass" value="<%=passwordValue==null?"":passwordValue%>">
			<font color="red"><%=passwordError==null?"":passwordError %></font></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><input type="text" name="email" value="<%=emailValue==null?"":emailValue%>">
			<font color="red"><%=emailError==null?"":emailError %></font></td>
		</tr>
	     
	     <tr>
	     	<td colspan="2" align="center"> <input type="submit" value="Sign up"> </td>
	     </tr>
		</table>
	</form>
	<%=error==null?"":error %>
</body>
</html>