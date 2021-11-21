<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MusicApe | LIST OF USERS</title>
	</head>

	<body>
	
		<jsp:useBean id="usersListKey" scope = "session" class = "java.util.ArrayList"></jsp:useBean>
		
		<a href = "jsp/AdminLogin.jsp">Return to admin home page</a>

		<h1>USERS LIST TABLE</h1>

		<table border = "1">
		
			<tr>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>EMAIL</th>
				<th>USERTYPE</th>
			
			</tr>
		<c:forEach var = "u" items = "${usersListKey}">
			<tr>
				<td>${u.username}</td>
				<td>${u.password}</td>
				<td>${u.email}</td>
				<td>${u.usertype}</td>
			</tr>
		</c:forEach>
		
		</table>
	
	</body>
</html>