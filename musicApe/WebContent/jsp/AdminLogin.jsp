<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MusicApe | ADMIN</title>
		
			<!-- FONTAWESOME CDN -->
		<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"/>
		
			<!-- STYLESHEET -->
		<link rel = "stylesheet" 
			href = "../cssMeta/adminHomePage.css"/>
			
	</head>
	
	<body>
		<jsp:useBean id="userKey" scope = "session" class = "model.User"></jsp:useBean>
		<nav class = "navbar">
			<ul>
				<li class = "brand"><a href = "../index.html"><i class = "fab fa-spotify"></i> MusicApe</a></li>
				<li>Music Around The World!</li>
				<li class = "username">WELCOME ${userKey.username}</li>
			</ul>
		</nav>

	
	<form action = "../AdminController" method="get">
		<p style="color: #00d4ff;">USERS LIST:</p>
		<input type="submit" value = "SEARCH">
	
	</form>


	</body>
</html>