<! DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
</style>

</head>
<body>
<div class="wrap-contact100">
<form action="success.html">
<div class="auth-form-body mt-3">


<div class="wrap-input100 validate-input" data-validate="Name is required">
<input class="input100" type="text" name="companyName" placeholder="Company Name">
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<input class="input100" type="text" name="Company Location" placeholder="Enter company location">
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<input class="input100" type="text" name="current Designation" placeholder="Enter current designation">
<span class="focus-input100"></span>
</div>

<div class="wrap-input100 validate-input" data-validate="Name is required">
<input class="input100" type="text" name="country" placeholder="Enter country name">
<span class="focus-input100"></span>
</div>


<button id="" type="submit"><a href="Success.html">SUBMIT</a></button>
</div>
</form>
</div>
</body>
</html>