<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message.generic}</h1>
<form method="post" action="login">
	<table class="login">
	  <tr class="header">
	    <td><img src="images/swic-logo-rect.gif"></img></td>
	    <td id="title">CIS 288</td>
	  </tr>
	  <tr>
	    <td>Email</td>
	    <td><input type="text" name="email"></input></td>
	  </tr>
	  <tr>
	    <td>Password</td>
	    <td><input type="password" name="password"></input></td>
	  </tr>
	  <tr>
	    <td><a href="signup">Create Account</a></td>
	    <td><a href="UserInfo">User Info</a></td>
	    <td align="right"><input type="submit" id="submit" value="Login"></input></td>
	  </tr>
	</table>
</form>
</body>
</html>