<! DOCTYPE html>
	
<html>
<%@ include file="/WEB-INF/templates/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<style>
.popupContainer  {
	display: none;
}
.popupContainer.popup_small{top:25%; width: 250px; left: 40%; padding: 25px; margin: 0; display: block;}
.popupContainer.popup_small .popupWindow {
  top: 25%;
  width: 250px;
  left: 40%;
  padding: 25px;
  margin: 0;
  display: block;
}

.popupContainer .popupOverlay, .popupContainer.popup_small .popupOverlay  {
	position:fixed;
	top:0;
	left:0;
	background:#000;
	opacity: 0.6;
	filter: alpha(opacity=60);
	z-index:5;
	width:100%;
	height:100%;
	z-index: 9999999;
}
.popupContainer .popupWindow{
	margin:0 auto;
	position:fixed;
	z-index:9999999999999999999999;
	top: 200px;
	left:25%;
	width: 80%;
	
	border:1px solid #6a0f07;
	/* padding-bottom: 40px; */
	padding:0px 25px 10px;
	background: #fcf9f1;
	color: #6a0f07;
	font-size: 14px;
	text-align: center;

}
.popupContainer .popupWindowForm {
	position:absolute;
	top: 200px;
	left: 28%;
	width: 400px;
	border:1px solid #6a0f07;
	padding-bottom: 40px;
	padding-left:20px;
	background: #FFF;
	color: #6a0f07;
	font-size: 14px;
	text-align: center;
	padding-right: 20px;

}
.popUpForm:input{
	width:300px;
}
.popupWindowForm select{
	width:180px;
}
.popupContainer .popupWindow .popupCloseBtn,.popupContainer .popupWindowForm .popupCloseBtn  {
	background: transparent url(static/images/popupCloseBtn.png) 0 0 no-repeat;
	height: 20px;
	width: 20px;
	float: right;
	position: absolute;
	right: 10px;
	top: 10px;
	z-index: 1001
}

</style>
<body>
	<div class="auth-form px3">
		<div style="color: red">${error}</div>
		<div class="loader"></div>
		<form:form action="verificationOTP" id="pofile" modelAttribute="user" name="userProfile" enctype="multipart/form-data">
			<div class="auth-form-header p-0">
				<h3 style="text-align: center">User Registration</h3>
			</div>

			<div id="OTPDiv" style="display: none" class="auth-form-body mt-3">
				<label style="color: green">OTP sent to mobile number <span id="sub_mob_id"></span> </label> 
				<label>Enter OTP <strong>*</strong></label>
				<form:input path="otp" type="password"
					class="form-control input-block" placeholder="Enter OTP "
					name="otp" maxlength="6" />
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
					
			<%-- 	<label class="control-lable" for="file">Upload a file</label>
                <form:input type="file" path="file" id="file" class="form-control input-sm"/> --%>
					
				<label>Password<strong>*</strong></label>
				<form:input path="password" type="password" id="password" maxlength="21"
					class="form-control input-block" placeholder="Enter Password"
					name="Password" required="required"/>
					
				<label>Confirm Password<strong>*</strong></label>
				<form:input path="confirmPassword" type="password" id="confirmPassword" maxlength="21"
					class="form-control input-block" placeholder="Confirm Password"
					name="ConfirmPassword" required="required"/>

				<input value="Generate OTP" id="register" type="button" name="register" class="btn btn-primary btn-block" onclick="genrateOTP()"> 
						
			</div>
			<div id="OtpBtn" class="">
				<table class="">
					<tr style="width: 5px;">
						<td>
							<button id="Submit" type="submit" name="Submit" class="btn" style="display: none" onclick="getLoader()" value="">
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
			
					<div class="popupContainer" id="ajaxLoader" style="display: none;">
			<div class="popupWindow" style="top: 300px; left:12%;background: none; border: none;">
				<img src="static/images/loading1.gif">
			</div>
			<div class="popupOverlay"></div>
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
	$("#ajaxLoader").show();	
 	if(!$("#pofile").valid()){
 		$("#ajaxLoader").hide();
 		return false;
 	}
	var mob_no = $("#mob").val();
	$('#sub_mob_id').text(mob_no);
	
	// $(".loader").show();
	  $.ajax({
		url: '/DriverConnect/genrateOTP',
		data: "mobile_no="+mob_no,
	    async: true,
	    contentType: false,
	    processData: false,
	    success: function (returndata) {
	        var response=returndata;
	   //     $(".loader").fadeOut("slow");
	    	$("#Submit").show();
	    	$("#OTPDiv").show();
	    	$("#MobDiv").hide();
	    	$("#notesDiv").hide();
	    	$("#otp").rules("add","required");
	    	$("#ChangeMob").show();
	    	$("#RESENDOTP").show();
	    	$("#register").hide();
	    	$("#ajaxLoader").hide();
   		
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
	         },
	         otp:{
	        	 required: "This field is required",
	        	 
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
function getLoader(){
	//$("#ajaxLoader").show();
}
</script>




</body>

</html>






