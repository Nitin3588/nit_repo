<! DOCTYPE html>
	
<html>

<%@ include file="/WEB-INF/templates/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<body>
	<div class="auth-form px3">
		<div class="loader"></div>
		<form:form action="verificationOTP.html" id="pofile" modelAttribute="user" name="userProfile" enctype="multipart/form-data">
			<div class="auth-form-header p-0">
				<h3 style="text-align: center">User Registration</h3>
			</div>

			<div id="OTPDiv" style="display: none" class="auth-form-body mt-3">
				<label style="color: green">OTP sent to mobile number 
					*******7890</label> <label>Enter OTP <strong>*</strong></label>
				<form:input path="otp" type="password"
					class="form-control input-block" placeholder="Enter OTP "
					name="MobileNumber" />
			</div>

			<div id="MobDiv" class="auth-form-body mt-3">

				<label>First Name<strong>*</strong></label>
				<form:input path="firstName" id="firstName" class="form-control input-block"  
					placeholder="Enter First Name" name="firstName" required="required" />

				<label>Last Name<strong>*</strong></label>
				<form:input path="lastName" id="lastName" class="form-control input-block"
					placeholder="Enter Last Name " name="lastName" required="required" />

				<label>Enter your Mobile Number<strong>*</strong></label>
				<form:input path="mobileNo"  id="mob" class="form-control input-block"
					onkeypress="return isNumberKey(event)" maxlength="10"
					placeholder="Enter Mobile Number" name="MobileNumber" required="required" />

				<label>Email<strong>*</strong></label>
				<form:input path="email" type="email"
					class="form-control input-block" id="email" placeholder="Enter Email ID "
					name="EmailId" required="required" />
					
				<label class="control-lable" for="file">Upload a file</label>
                <form:input type="file" path="file" id="file" class="form-control input-sm"/>
					
				<label>Password<strong>*</strong></label>
				<form:input path="password" type="password" id="password" maxlength="21"
					class="form-control input-block" placeholder="Enter Password"
					name="Password" required="required"/>
					
				<label>Confirm Password<strong>*</strong></label>
				<form:input path="confirmPassword" type="password" id="confirmPassword" maxlength="21"
					class="form-control input-block" placeholder="Confirm Password"
					name="ConfirmPassword" required="required"/>

				<input value="SIGN IN" id="register" type="button" name="register" class="btn btn-primary btn-block" onclick="genrateOTP()"> 
						
			</div>
			<div id="OtpBtn" class="">
				<table class="">
					<tr style="width: 5px;">
						<td>
							<button id="Submit" type="submit" name="Submit" class="btn" style="display: none" value="">
								Submit 
							</button>
						</td>
						<td>
							<button id="ChangeMob" type="button" name="ChangeMob" class="btn "
								onclick="" style="display: none">
								<a href="register">Change mobile number</a>
							</button>
						</td>
						<td><button id="RESENDOTP" type="button" name="RESEND OTP"
								class="btn" onclick="" style="display: none">Resend OTP</button></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>


	<div id="notesDiv" style="" class="notes">
		<strong>Note</strong>
		<ul>
			<li>Please fill up all mandatory details (the details which are
				marked with *)</li>
		</ul>
		<ul>
			<li>After click on sign in otp will be sent to registered mobile
				number</li>
		</ul>
	</div>

<script>


	function genrateOTP(){
 	
	var mob_no = $("#mob").val();
	// $(".loader").show();
	  $.ajax({
		url: '/DriverConnect/genrateOTP',
		data: "mobile_no="+mob_no,
	    async: true,
	    contentType: false,
	    processData: false,
	    success: function (returndata) {
	        var compalinData=returndata;
	   //     $(".loader").fadeOut("slow");
	   
	    	$("#Submit").show();
	    	$("#OTPDiv").show();
	    	$("#MobDiv").hide();
	    	$("#notesDiv").hide();


	    	$("#ChangeMob").show();
	    	$("#RESENDOTP").show();
	    	$("#register").hide();

   		
	    }
	  });
	
}
	

	function  isNumberKey(evt){
	    var charCode = (evt.which) ? evt.which : event.keyCode
	    if (charCode > 31 && (charCode< 48 || charCode >57))
	        return false;
	    return true;
	}
	
	function ValidateEmail(inputText)
	{
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(inputText.value.match(mailformat))
		{
			return true;
		}
	else
		{
			alert("You have entered an invalid email address!");
		return false;
		}
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
	
	
	
	$(document).ready(function() {
		  // Initialize form validation on the registration form.
		  // It has the name attribute "registration"
		  $("#pofile").validate({
		    // Specify validation rules
		    rules: {
		      // The key name on the left side is the name attribute
		      // of an input field. Validation rules are defined
		      // on the right side
	            firstName: {
	                required: true,
	                check_name : true
	            },
	            lastName: {
	                required: true,
	                check_name : true
	            },
	            mob: {
	                required: true,
	                digits:true,
	                maxlength:10,
	                minlength:10
	            },
	            email: {
	                required: true,
	                email:true
	            },
	            password: {
	   	         required: true,
	   	         minlength: 5
			   	 },
			   	 confirmPassword: {
	   	         required: true,
	   	         minlength: 5,
	   	         equalTo: "#password"
	         }
		    },
		    // Specify validation error messages
		    messages: {
	            firstName: {
	                required: "This field is required",
	                check_name : "Please provide valid detail"
	            },
	            lastName: {
	                required: "This field is required",
	                check_name : "Please provide valid detail"
	            },
	            mob: {
	                required: "This field is required",
	                digits:"only digits are allowed",
	                maxlength : 'Please enter mobile number of valid length',
	                minlength : 'Please enter mobile number of valid length'
	             },
	            email: {
	                required: "This field is required",
	                email:"Please provide valid email id"
	            },
	            password: {
	   	         required: "This field is required",
	   	      	 minlength: "Your password must be at least 5 characters long"
			   	 },
			   	 confirmPassword: {
	   	         required: "This field is required",
	   	         minlength: "Your password must be at least 5 characters long",
	   	         equalTo: "Please enter the same password as above"
	         }
		    },
		    // Make sure the form is submitted to the destination defined
		    // in the "action" attribute of the form when valid
		    submitHandler: function(form) {
		      form.submit();
		    }
		  });
		});
	
	
	jQuery.validator.addMethod("regEx", function(value, element, param) {
		return value.match(new RegExp("^" + param + "$"));
	});
	$.validator.addMethod("check_name", function(value,
			element) {
		if (this.optional(element)) {
			return true;
		}
		return /^(?=\S)[a-zA-Z'][a-zA-Z '][a-zA-z]+$/.test(value);
	});

</script>




</body>

</html>






