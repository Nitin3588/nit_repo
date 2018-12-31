<! DOCTYPE html>
<html>
<head>
	<title>Home Page</title>
<head>
<%@ include file="/WEB-INF/templates/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style>

input {
    outline: none;
    border: none;
}

.wrap-contact100 {
    width: 600px;
    height:600px;
    background: #fff;
    border-radius: 10px;
    overflow: hidden;
    padding: 42px 55px 45px 55px;
}
.contact100-form {
    width: 100%;
}

* {
    margin: 0px;
    padding: 0px;
    box-sizing: border-box;
}

*, ::after, ::before {
    box-sizing: inherit;
}

input.input100 {
    height: 40px;
}


form {
    display: block;
    margin-top: 0em;
}
.input100 {
    display: block;
    width: 100%;
    background: transparent;
    font-family: Poppins-Medium;
    font-size: 18px;
    color: #333333;
    line-height: 1.2;
    padding: 0 5px;
}

.focus-input100 {
    position: absolute;
    display: block;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    pointer-events: none;
}
body {
    margin: 0;
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: lightgrey;
}

.validate-input {
    position: relative;
}
.wrap-input100 {
    width: 100%;
    position: relative;
    border-bottom: 2px solid #d9d9d9;
    padding-bottom: 13px;
    margin-bottom: 27px;
}
* {
margin: 0px;
    padding: 0px;
    box-sizing: border-box;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

</style>

</head>
<body>
<form:form action="recruitBasicDetails" modelAttribute="recruiterProfile" method="post" name="form1" id="form1">

<table>
<tr>
<td>
		<div class="wrap-contact100">
			<div class="auth-form-body mt-3">
		
		    <div class="imgcontainer">
			      <img src="static/images/img_avatar3.png" id="img" alt="Avatar" class="avatar">
			      <input type='file' />
		    </div>
		
		
		
		<div class="wrap-input100 validate-input" data-validate="Name is required">
			<form:input class="input100" type="text" path="fullName" name="fullName" id="fullName" placeholder="Enter your full name"/>
			<span class="focus-input100"></span>
		</div>
		
		<div class="wrap-input100 validate-input" data-validate="Name is required">
			<form:input class="input100" type="text" path="DateOfBirth" name="DateOfBirth" id="DateOfBirth" placeholder="Enter your date of birth"/>
			<span class="focus-input100"></span>
		</div>
		
		
		<div class="wrap-input100 validate-input" data-validate="Name is required">
			<form:input class="input100" type="text" path="mobileNumber" name="mobileNumber" id="mobileNumber" placeholder="Enter Mobile  Number"/>
			<span class="focus-input100"></span>
		</div>
		</div>
		</div>
</td>

<td>
<div class="wrap-contact100">
<div class="auth-form-body mt-3">


<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:input class="input100" type="text" id="companyName" path="companyName" name="companyName" placeholder="Company Name"/>
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:input class="input100" type="text" id="companyLocation" path="companyLocation" name="companyLocation" placeholder="Enter company location"/>
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:input class="input100" type="text" id="currentDesignation" path="currentDesignation" name="currentDesignation" placeholder="Enter current designation"/>
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<input class="input100" type="text" id="country" path="country" name="country" placeholder="Enter country name">
<span class="focus-input100"></span>
</div>

<input id="" type="submit" class="btn btn-primary" value="CANCEL">
<input id="" type="submit" class="btn btn-primary" value="SUBMIT">
</div>
</div>

</td>
</tr>


</table>
</form:form>
</body>
</html>



<script>

$(function () {
    $(":file").change(function () {
        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[0]);
        }
    });
});

function imageIsLoaded(e) {
    $('#img').attr('src', e.target.result);
};




$(document).ready(function() {

$("#form1").validate({
  rules: {

    ExpiryDate : {
    required : true,
    },
    fullName: {
	        required: true,
	        check_name : true
     },
    DateOfBirth: {
	         required: true,
	 },
	 mobileNumber: {
	         required: true,
	         digits:true,
	         maxlength:12
      },
      companyName:{
    	  required: true,
    	  check_name : true
      },
      CompanyLocation:{
    	  required: true,
    	  check_name : true
    	  
      },
      currentDesignation:{
    	  required: true,
    	  check_name : true
      },
      country:{
    	  required: true,
    	  check_name : true
      }
  },
  messages: {
    ExpiryDate :{
    required : 'This field is required'
    },
    fullName: {
    	required :"Please enter a name",
    	check_name : "Please enter a valid Name"
    },
    DateOfBirth: {
	        required: "Please provide a DOB",
    },
    mobileNumber: {
	         required: "Please provide mobile number",
	         digits :"Only digits are allowed",
	         maxlength:"Please provide valid mobile number"
	         
      },
      companyName :{
    	  required : 'This field is required',
    	  check_name : "Please enter a valid Name"
      },
      companyLocation :{
    	  required : 'This field is required',
    	  check_name : "Please enter a valid Name"
      },
      currentDesignation :{
    	  required : 'This field is required',
    		  check_name : "Please enter a valid Name"
      },
      country :{
    	  required : 'This field is required',
    	  check_name : "Please enter a valid Name"
      }

  }
});});


$.validator.addMethod("check_name", function(value,
		element) {
	if (this.optional(element)) {
		return true;
	}
	return /^(?=\S)[a-zA-Z '][a-zA-Z '][a-zA-z ]+$/.test(value);
});



</script>