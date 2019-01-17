<! DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<head>
<%@ include file="/WEB-INF/templates/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="style.css"/>
 -->
<style>

input {
    outline: none;
    border: none;
}

.wrap-contact100 {
    width: 500px;
    height:500px;
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
</style>

</head>
<body>
<div class="auth-form-header p-0">
		<h2 style="text-align:center">JOB POSTING</h2>
	</div>

<form:form name="form1" id="form1" action="recruiterPostingJobs" modelAttribute="jobPostingForm">
<form:errors path="*" element="p" />
<table>
<tr>
<td>
<div class="wrap-contact100">
<div class="auth-form-body mt-3">
<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:input class="input100" type="text" path="jobTitle" name="jobTitle" placeholder="JOB TITLE / DESIGNATION"/>
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">

<form:select path="Emptype" id="Emptype" name="Emptype">
<option value="P">Part time</option>
<option value="F">Full time</option>
<option value="O">Other time</option>

</form:select>
<%-- <form:input class="input100" type="text" path="Emptype" name="Emptype" placeholder="Enter Employement type"/>
 --%><span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:textarea  rows="10" cols="30" path="description" name="description" placeholder="Enter job description"/>
<span class="focus-input100"></span>
</div>


</div>
</div>
</td>
<td>
<div class="wrap-contact100">
<div class="auth-form-body mt-3">
<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:input class="input100" type="text" path="imp" name="imp" placeholder="Enter important things"/>
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<table>
<tr><td>
<label>Min Exp required</label><form:select path="minWorkexp" class="1-10"></form:select></td>
<td><label>Max Exp required</label><form:select path="maxWorkexp" class="1-10"></form:select></td>
</tr>
</table>
<%-- <form:input class="input100" type="text" path="workexp" name="workexp" placeholder="Enter work experience required"/> --%>
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:input class="input100" type="text" path="workLocation" name="workLocation" placeholder="Enter company's work location"/>
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<form:input class="input100" type="text" path="hiringFlag" name="hiringFlag" placeholder="Company is hiring for"/>
<span class="focus-input100"></span>
</div>
<input id="" value="submit" type="submit"/>


</div>
</div>
</td>
</tr>
</table>


</form:form>

</body>
</html>



<script>
$(function(){
    var $select = $(".1-10");
    for (i=1;i<=10;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});


$(document).ready(function() {

	$("#form1").validate({
	  rules: {

		  jobTitle : {
	    required : true,
	    check_name : true
	    },
	    Emptype: {
		        required: true
		},
		description: {
		         required: true
		 },
		 imp: {
		         required: true
	      },
	      minWorkexp:{
	    	  required: true
	      },
	      maxWorkexp:{
	    	  required: true
	      },
	      workLocation:{
	    	  required: true
	      },
	      hiringFlag:{
	    	  required: true
	      }
	  },
	  messages: {
		  jobTitle :{
			    required : 'This field is required',
	    		check_name : "Please enter a valid Name"
	    },
	    Emptype: {
	    	required :"Please select a employee type",
	    },
	    description: {
		        required: "Please provide job description with specified skills required"
	    },
	    imp: {
		         required: "Please provide mobile number"
	      },
	      minWorkexp :{
	    	  required : 'This field is required'
	      },
	      maxWorkexp :{
	    	  required : 'This field is required'
	      },
	      workLocation :{
	    	  required : 'This field is required'
	      },
	      hiringFlag :{
	    	  required : 'This field is required'
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