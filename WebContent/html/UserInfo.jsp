<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Here are your cars<br><br>
User ID: ${UserInfo.UserID}<br>
First Name: ${UserInfo.FirstName}<br>
Last Name: ${UserInfo.LastName}<br> 
Password: ${UserInfo.Password}<br> 
Street Address: ${UserInfo.StreetAddress}<br>
Apt Number: ${UserInfo.AptNumber}<br>
City: ${UserInfo.City}<br>
State: ${UserInfo.State}<br>
Zip Code: ${UserInfo.Zip}<br>
Email: ${UserInfo.Email}<br>
Sex: ${UserInfo.Sex}<br>
Interests: ${UserInfo.Interests}<br><br>
Cars:
<table>
	<tr>
		<td>Make</td><td>Model</td><td>Year</td><td>Color</td><td>Current Value</td>
	</tr>
<c:forEach var="car" items="${Cars.cars}">
	<tr>
		<td>${car.make}</td>
		<td>${car.model}</td>
		<td>${car.year}</td>
		<td>${car.color}</td>
		<td>${car.currentValue}</td>
	</tr>
</c:forEach>
</table>



<br>
<a href="ServletOne">Login</a><br><br>
<form action="Logout" method="get">
	<input type="submit" value="Logout">
</form>

</body>
</html>