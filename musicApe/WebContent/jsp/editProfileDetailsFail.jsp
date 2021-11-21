<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>MusicApe | Edit Details</title>
	
				<!-- FONTAWESOME CDN -->
		<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"/>
		
			<!-- STYLESHEET -->
		<link rel = "stylesheet" 
			href = "../cssMeta/editProfileDetails.css"/>	

	</head>
	<body>		
		<nav class = "navbar">
			<ul>
				<li class = "brand"><a href = "../index.html"><i class = "fab fa-spotify"></i> MusicApe</a></li>
				<li>Music Around The World!</li>
			</ul>
		</nav>
		
		<jsp:useBean id="userKey" scope = "session" class = "model.User"></jsp:useBean>
		
		<form action = "../EditProfileDetailsController" method = "get">
			<fieldset>
			<legend>PROFILE UPDATE FAILED CHECK INPUTS</legend>
					<!-- NAME -->
				<label for="name" style="color: #00d4ff ; font-family: 'Lato',sans-serif">FULL NAME</label>
				<input type="text" name="name"		
				id="name">
					<!-- DJ NAME -->
				<label for="djname" style="color: #00d4ff ; font-family: 'Lato',sans-serif">DJ NAME</label>
				<input type="text" name="djname"		
				id="djname">
					<!-- DESCRIPTION -->
				<label for="description" style="color: #00d4ff ; font-family: 'Lato',sans-serif">DESCRIPTION</label>
				<input type="text" name="description"		
				id="description">
					<!-- SOUNDCLOUD -->
				<label for="soundcloud" style="color: #00d4ff ; font-family: 'Lato',sans-serif">SOUNDCLOUD URL</label>
				<input type="text" name="soundcloud"		
				id="soundcloud">
					<!-- GENRE -->
				<label for="genre" style="color: #00d4ff ; font-family: 'Lato',sans-serif">DESIRED GENRE</label>
				<select name="genre" id="genre">
					<option value = "disco">Disco</option>
					<option value = "dubstep">Dubstep</option>
					<option value = "funk">Funk</option>
					<option value = "house">House</option>
					<option value = "indie">Indie-Dance</option>
					<option value = "psy">Psy-trance</option>
					<option value = "techno">Techno</option>
					<option value = "trance">Trance</option>
					<option value = "ukGarage">UK Garage</option>
				</select>
				<input type = "hidden" name = "id" value = "${userKey.id}"> 
				
				<br>
				<br>
				
				<input type="submit" id="submit"
				value="UPDATE PROFILE">
			</fieldset>
		
		</form>
	
	
	
	
	
	
	</body>
</html>