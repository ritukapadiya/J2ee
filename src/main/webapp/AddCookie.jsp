<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddCookieServlet" method="post">
		CookieName: <input type="text" name="cookieName"><br> <br>
		CookieValue: <input type="text" name="cookieValue"><br><br>
		<input type="submit" value="Add Cookie">
	</form>
</body>
</html>