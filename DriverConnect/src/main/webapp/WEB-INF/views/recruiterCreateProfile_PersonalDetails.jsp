<! DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css"/>

<style>

input {
    outline: none;
    border: none;
}

.wrap-contact100 {
    width: 500px;
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
<div class="wrap-contact100">
<form action="recruitBasicDetails.html" method="post" name="form1" id="form1">
<div class="auth-form-body mt-3">

    <div class="imgcontainer">
      <img src="static/images/img_avatar3.png" id="img" alt="Avatar" class="avatar">
      <input type='file' />
    </div>



<div class="wrap-input100 validate-input" data-validate="Name is required">
<input class="input100" type="text" name="name" id="name" placeholder="Enter your full name">
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<input class="input100" type="text" name="DateOfBirth" id="DateOfBirth" placeholder="Enter your date of birth">
<span class="focus-input100"></span>
</div>


<div class="wrap-input100 validate-input" data-validate="Name is required">

<input class="input100" type="text" name="MobileNumber" id="MobileNumber" placeholder="Enter Mobile  Number">
<span class="focus-input100"></span>
</div>

<table border="0">
<tr>
<td><input id="proceed" type="submit" value="PROCEED"></td>
<td><input id="cancel" type="submit" value="CANCEL"></td>
</tr>
</table>

</div>
</form>
</div>
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
    name: {
	        required: true,
     },
    DateOfBirth: {
	         required: true,
	 },
	 LicenseNumber: {
	         required: true,
      }
  },
  messages: {
    ExpiryDate :{
    required : 'This field is required',
    },
    name: "Please enter a valid email address",
    DateOfBirth: {
	        required: "Please provide a password",
    },
	 LicenseNumber: {
	         required: "Please provide license number",
      }

  }
});});




</script>