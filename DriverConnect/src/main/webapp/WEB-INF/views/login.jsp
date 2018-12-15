
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body >
	<div id="container" class="container">
		<form:form name="loginForm" method="POST">
			<div align="center">
				<table>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="userName" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="number" name="mobile" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="login" /></td>
					</tr>
				</table>
				<div style="color: red">${error}</div>
			</div>
		</form:form>

	</div>


</body>
</html>