<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
<%@ include file="/WEB-INF/templates/header.jsp" %>
</head>
<body>
	<div class="container table col-md-6">
		<form:form id="pofile" modelAttribute="user"  name="userProfile">
			<table>
				<tr>
					<td ><label >First Name</label></td>
					<td ><form:input path="firstName" ></form:input></td>
				</tr>
				<tr>
					<td ><label >Last Name</label></td>
					<td><form:input path="lastName" ></form:input></td>
				</tr>
				<tr>
					<td ><label >Mobile</label></td>
					<td><form:input path="mobileNo" ></form:input></td>
				</tr>
				<tr>
					<td ><label >Email</label></td>
					<td><form:input path="email" ></form:input></td>
				</tr>
			</table>
			<div>
				<button type="submit" class="button">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>