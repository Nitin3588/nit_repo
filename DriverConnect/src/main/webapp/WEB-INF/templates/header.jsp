<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<head>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
 --><link href="static/css/style.css"  rel="stylesheet" type="text/css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
 --><!-- <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
 -->
</head>


<body>
	<div id="container">
		<c:choose>
			<c:when test="${empty loggedInUser.firstName}">
				<label style="color: red"><a href="login">Login</a></label>
				<label style="color: red"><a href="register">Register</a></label>
			</c:when>
			<c:otherwise>
				<spring:message code="welcome"></spring:message>
				<label> ${loggedInUser} </label>
				<label style="color: blue"><a href="logout">Logout</a></label>
				<label style="color: blue"><a href="profile">View Profile</a></label>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
