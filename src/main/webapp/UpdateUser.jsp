<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateUserServlet" method="post">
		<input type="hidden" value="${userBean.getEmail()}" name="email"><br><br>
		FirstName: <input type="text" value="${userBean.getFirstName()}" name="firstName"> <br><br>
		LastName: <input type="text" value="${userBean.getLastName()}" name="lastName"> <br><br>
		Password: <input type="text" value="${userBean.getPassword()}" name="password"> <br><br>
		<input type="submit" value="Update">
	</form>
</body>
</html>