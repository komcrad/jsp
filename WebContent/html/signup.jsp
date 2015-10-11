<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message.header}</h1>
<form action="signup" method="post">

	First Name*: <input name="firstName" type="text" value="${param.firstName}" required><br>
	Last Name*: <input name="lastName" type="text"  value="${param.lastName}" required><br>
	Password*: <input name="password" type="password"  value="${param.password}" required> <strong> ${errors.password} </strong><br>
	Street Address: <input name="streetAddress" value="${param.streetAddress}" type="text"><br>
	Apt Number: <input name="aptNumber" value="${param.aptNumber}" type="text"><br>
	City: <input name="city" type="text" value="${param.city}"><br>
	State: <input name="state" type="text" value="${param.state}"><br>
	Zip Code: <input name="zipCode" type="text" value="${param.zipCode}"><br>
	Email Address*: <input name="email" type="text" value="${param.email}" required> <strong> ${errors.email} </strong><br>
	Sex*:
	<label>Male</label><input name="sex" type="radio" value="male" ${sex.male} required>
	<label>Female</label><input name="sex" type="radio" value="female" ${sex.female}><br>
	Interests*: <strong> ${errors.interests} </strong><br>
	Hiking <input name="interests" type="checkbox" value="hiking" ${interest.hiking}>
	Running <input name="interests" type="checkbox" value="running" ${interest.running}>
	Reading <input name="interests" type="checkbox" value="reading" ${interest.reading}>
	Sleeping <input name="interests" type="checkbox" value="sleeping" ${interest.sleeping}>
	Programming <input name="interests" type="checkbox" value="programming" ${interest.programming}><br>
	<input type="submit" value="Create Account" id='submit'>
</form>
</body>
</html>