<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="AddProductServlet" method = "post">

 	Name: <input type="text" name="name"> ${nameError}<br><br>
 	Price: <input type="text" name="price"> ${priceError}<br><br>
 	Quantity: <input type="text" name="qty"> ${qtyError}<br><br>
 	<input type="submit" value="Add Product"> 
 </form>
</body>
</html>