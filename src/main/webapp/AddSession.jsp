<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddSessionServlet" method="post">
	Session email: <input type="text" name="sessionName"><br><br>
	Session password: <input type="text" name="sessionValue"><br><br>
	<input type="submit" value="Add Session">

</form>
</body>
</html>