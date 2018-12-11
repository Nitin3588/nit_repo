<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"  %>

<html>
<head>
<title>Welcome</title>
</head>
<body>
	<form:form id="login" modelAttribute="user">
		<table>
			<tr>
				
				<td>Welcome  ----- ${user.firstname}</td>   
			</tr>
			<tr>
				<td><form:input path="firstname"></form:input></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td><a href="home">Home</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
