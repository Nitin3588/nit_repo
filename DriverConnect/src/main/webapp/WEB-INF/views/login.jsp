<! DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/templates/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
</head>
<body>
	<div class="auth-form px3">
		<div style="color: red">${error}</div>
		<form:form id="loginForm" name="loginForm" action="login" method="POST" modelAttribute="user">

			<div class="auth-form-header p-0">
				<h4 style="text-align: center">Sign in to Driver Connect</h4>
			</div>

			<div class="auth-form-body mt-3">

				<label for="login_field"> UserId <a class="label-link"
					href="/password_reset">Forgot password?</a>
				</label>

				<form:input type="text" path="userloginId" id="login_field"
					class="form-control input-block" tabindex="1" autocapitalize="off"
					autocorrect="off" autofocus="autofocus" />

				<label for="password"> Password </label>
				<form:input type="password" path="password" id="password"
					class="form-control form-control input-block" tabindex="2" />

				<input type="submit" name="commit" value="Sign in" tabindex="3"
					class="btn btn-primary btn-block">
			</div>

			<p class="create-account-callout mt-3">
				New to Driver Connect <a href="register">Create an account</a>.
			</p>
		</form:form>
	</div>
</body>
</html>


<script>

$(document).ready(function() {

	$("#loginForm").validate({
	  rules: {
		  login_field:{
			  required: true,
		  },
          password: {
	   	         required: true,
		  }
	  },
	  messages: {
		  login_field:{
			  required: "This field is required",
		  },
		  password: {
	   	         required: "This field is required",
			   	 }
	  },
	});});


</script>