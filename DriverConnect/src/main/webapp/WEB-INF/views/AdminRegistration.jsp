<! DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<div class="auth-form px3">
<form action="">
	<div class="auth-form-header p-0">
		<h2 style="text-align:center">Admin Registration</h2>
	</div>
	
	

		<div id="OTPDiv" style="display:none" class="auth-form-body mt-3">
			<label style="color:green">OTP sent to mobile number *******7890</label>
			<label>Enter OTP <strong>*</strong></label>
			<input type="password" class="form-control input-block" placeholder="Enter OTP " name="MobileNumber">
		</div>

	
		<div id="MobDiv"  class="auth-form-body mt-3">
			<label>Enter your Mobile Number<strong>*</strong></label>
			<input type="text" class="form-control input-block" onkeypress="return isNumberKey(event)" maxlength="10" placeholder="Enter Mobile Number" name="MobileNumber">
		
			<label>Email<strong>*</strong></label>
			<input type="email" class="form-control input-block" placeholder="Enter Email ID " name="EmailId">

			<label>Password<strong>*</strong></label>
			<input type="password" class="form-control input-block" placeholder="Enter Password" name="Password">

			<label>Confirm Password<strong>*</strong></label>
			<input type="password" class="form-control input-block" placeholder="Confirm Password" name="ConfirmPassword">
		
			<button id="register" type="button" name="register" class="btn btn-primary btn-block" onclick="btnClick()">SIGN IN</button>
			</div>
			<div id="OtpBtn" class="">
			<table class="">
			<tr style="width:5px;">
			<td>
			<button id="Submit" type="button" name="Submit" class="btn" style="display:none"><a href="Success.html">Submit</a></button></td><td>
			<button id="ChangeMob" type="button" name="ChangeMob" class="btn" onclick="" style="display:none"><a href="Admin_RegistrationPage.html">Change mobile number</a></button></td>
			<td><button id="RESENDOTP" type="button" name="RESEND OTP" class="btn" onclick="" style="display:none">Resend OTP</button></td>
			</tr>
			</table>
		</div>
	</form>
	</div>
	
	
	<div id="notesDiv" style="" class="notes">
	<strong>Note</strong>
	<ul>
		<li>Please fill up all mandatory details (the details which are marked with *)</li>
	</ul>
	<ul>
		<li>After Click on Sign Up button OTP will be sent to entered mobile number </li>
	</ul>
	<ul>
		<li>And after click on submit your registration is done</li>
	</ul>
	
</div>
</body>		
</html>


<script>

function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}



function btnClick(){

	$("#Submit").show();
	$("#OTPDiv").show();
	$("#MobDiv").hide();
	$("#notesDiv").hide();
	
	
	$("#ChangeMob").show();
	$("#RESENDOTP").show();
	$("#register").hide();
}

</script>
