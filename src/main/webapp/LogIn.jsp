<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			 <form action="LogInServlet" method = "post">
				Email: <input type="text" name="email"> 	<font color="red"> ${emailError}</font> <br><br>
				Password: <input type="text" name="password"> 	<font color="red"> ${passwordError}</font> <br><br>
				<input type="submit" value="Log in"> <br><br>
				<font color="red"> ${error}</font> 
			</form>	
</body>
</html>


