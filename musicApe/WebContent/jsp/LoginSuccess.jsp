<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>MusicApe | WELCOME</title>
	
			<!-- FONTAWESOME CDN -->
		<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"/>
		
			<!-- STYLESHEET -->
		<link rel = "stylesheet" 
			href = "../cssMeta/userHomePage.css"/>	
	
	</head>

	<body>
	<jsp:useBean id="userKey" scope="session" class = "model.User"></jsp:useBean>
		<nav class = "navbar">
			<ul>
				<li class = "brand"><a href = "../index.html"><i class = "fab fa-spotify"></i> MusicApe</a></li>
				<li>Music Around The World!</li>
				<li class = "username">WELCOME ${userKey.username}</li>
			</ul>
		</nav>
	<div class = "editProfileDetails">
	
		<a href = "editProfileDetails.jsp">EDIT PROFILE DETAILS</a>
		
	</div>

	
	</body>
</html>