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
		
			<!-- FONTAWESOME CDN -->
		<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"/>
		
			<!-- STYLESHEET -->
		<link rel = "stylesheet" 
			href = "../cssMeta/usersList.css"/>
			
	</head>
		
	<body>
		<jsp:useBean id="usersListKey" scope = "session" class = "java.util.ArrayList"></jsp:useBean>
		
		<nav class = "navbar">
			<ul>
				<li class = "brand"><a href = "AdminLogin.jsp"><i class = "fab fa-spotify"></i> MusicApe</a></li>
				<li>Music Around The World!</li>
			</ul>
		</nav>
	
		<a href = "jsp/AdminLogin.jsp">Return to admin home page</a>

		<h1>USERS LIST TABLE</h1>
		<style> /* EDIT ZA TABLE */
			.userList-table{
				border-collapse: collapse;
				margin: 25px 0;
				font-size: 1.1em;
				min-width: 400px;
				border-radius: 5px 5px 0 0;
				overflow: hidden;
				box-shadow: 0 0 20px rgba(0, 0, 0, 0.50);
			}
			
			.userList-table thead tr{
				background-color: #660066;
				color: #00d4ff;;
				text-align: left;
				font-weight: bold;
			}
			.userList-table th,
			.userList-table td{
				padding: 12px 15px;
			}
			.userList-table tbody tr{
				border-bottom: 1px solid #dddddd;
			}
			
			.userList-table tbody tr: nth-of-type(even){
				background-color: #ffe6ff;
			}
			
			.userList-table tbody tr: last-of-type{
				border-bottom: 2px solid #660066;
			}
			
			.userList-table tbody tr.active-row{ 
				font-weight: bold;
				color: #660066;
			}
		
		</style>
		<table class="userList-table">
			<thead>
				<tr>
					<th>USERNAME</th>
					<th>PASSWORD</th>
					<th>EMAIL</th>
					<th>USERTYPE</th>
				
				</tr>
			</thead>
		<c:forEach var = "u" items = "${usersListKey}">
			<tbody>	
		
				<tr>
					<td>${u.username}</td>
					<td>${u.password}</td>
					<td>${u.email}</td>
					<td>${u.usertype}</td>
				</tr>
			
		
			</tbody>
		</c:forEach>
		</table>
	
	</body>
</html>