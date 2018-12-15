<html>
<head>
<%@ include file="/WEB-INF/templates/header.jsp"%>
<title>Welcome</title>
</head>
<body>
	<div id="container" class="container">
		<form:form id="login" modelAttribute="user">
			<table>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><form:input path="firstName"></form:input></td>
				</tr>
				<tr>
					<td><form:input path="userType"></form:input></td>
				</tr>
				<tr>
					<td><a href="home">Home</a></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
