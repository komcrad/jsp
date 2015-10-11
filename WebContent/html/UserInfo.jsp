<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Here are your cars<br><br>
User ID: ${UserInfo.userID}<br>
First Name: ${UserInfo.firstName}<br>
Last Name: ${UserInfo.lastName}<br> 
Password: ${UserInfo.password}<br> 
Street Address: ${UserInfo.streetAddress}<br>
Apt Number: ${UserInfo.aptNumber}<br>
City: ${UserInfo.city}<br>
State: ${UserInfo.state}<br>
Zip Code: ${UserInfo.zipCode}<br>
Email: ${UserInfo.email}<br>
Sex: ${UserInfo.sex}<br>
Interests: ${UserInfo.interests}<br><br>
Cars: ${UserInfo.cars}<br>
<a href="ServletOne">Login</a><br><br>
<form action="Logout" method="get">
	<input type="submit" value="Logout">
</form>

</body>
</html>