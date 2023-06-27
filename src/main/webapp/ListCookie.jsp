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
	Cookie c[] = (Cookie[]) request.getAttribute("allCookie");
	
%>

<%for(Cookie x:c){ %>
	
		<%=x.getName() %> -> <%=x.getValue() %> <br>

<%} %>

<h1>Enter details for Delete cookie</h1>
<form action="DeleteCookieServlet" method="get">
	cookie name: <input type="text" name = cookieName> <br><br>
	<input type="submit" value="Delete Cookie">
	
</form>
</body>
</html>