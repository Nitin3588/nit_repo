<! DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<head>
<%@ include file="/WEB-INF/templates/header.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="style.css" />

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


blink {
	animation: blinker 0.6s linear infinite;
	color: red;
}

@
keyframes blinker { 50% {
	opacity: 0;
}

}
.auth-form-body-reg {
	background-color: #fff;
	border: 1px solid #d8dee2;
	border-radius: 0 0 3px 3px;
	border-top: 0;
	font-size: 10px;
	padding: 30px;
}

.mt-reg-3 {
	margin-top: 20px !important;
}

.button {
	background-color: white; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
}

.button2:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}

.button3:hover {
	background-color: #008CBA;
	color: white;
}

.auth-form-reg {
	margin: 0 auto;
	width: 840px;
}

.px-3 {
	padding-right: 16px !important;
}

.button1 {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}
</style>

</head>
<body>
	<div class="auth-form-reg px3">
		<form action="" class="contact100-form validate-form">
			<div class="auth-form-header p-0" style="display:none">
				<h2 style="text-align: center">User Registration</h2>
			</div>

			<div id="MobDiv" class="auth-form-body-reg mt-reg-3" style="display:none">

				<table border="0">

					<tr>
						<td colspan="2"><button class="button button1 button3">
								<label style="color: black"><a 	href="SubscriberCreateProfile_PersonalDetails.html">
									Create Profile</label>
							</button></td>

						<td colspan="2"><button class="button button1 button3">
								<label style="color: black">Update My Profile</label>
							</button></td>

						<td colspan="1"><button class="button button1 button3">
								<label style="color: black">Show Profile Details</label>
							</button></td>
					</tr>

					<tr>
						<td colspan="2"><button class="button button1 button3">
								<label style="color: black">Apply For a Job</label>
							</button></td>

						<td colspan="2"><button class="button button1 button3">
								<label style="color: black">Status Of Applied Jobs</label>
							</button></td>
					</tr>

				</table>

			</div>

			<div class="auth-form-header p-0">
				<h2 style="text-align: center">Recruiter's Profile</h2>
			</div>

			<div id="MobDiv1" class="auth-form-body-reg mt-reg-3">

				<table>

					<tr>
						<td colspan="2"><button class="button button1 button3"
								onclick="recProfile()">
								<label style="color: black">Create Recruiter's Profile</label>
							</button></td>

						<td colspan="2"><button class="button button1 button3" disabled>
								<label style="color: black">Update Recruiter's Profile</label>
							</button></td>

						<td colspan="1"><button class="button button1 button3" disabled>
								<label style="color: black">Show Recruiter's Profile
									Details</label>
							</button></td>

					</tr>


					<tr>
						<td colspan="2"><button class="button button1 button3" onclick="jobPost()">
								<label style="color: black">
										Post a new job for subscriber
									</label>
							</button></td>

						<td colspan="2"><button class="button button1 button3" disabled>
								<label style="color: black">Status Of posted Jobs</label>
							</button></td>
					</tr>

				</table>

			</div>
			
								<div class="popupContainer" id="ajaxLoader" style="display: none;">
			<div class="popupWindow" style="top: 300px; left:12%;background: none; border: none;">
				<img src="static/images/loading1.gif">
			</div>
			<div class="popupOverlay"></div>
		</div>
			

		</form>

		<div id="notesDiv" style="" class="notes">
			<strong>Note</strong>
			<ul>
				<li>Use Create Profile Option to fill up personal details and
					contact details</li>
			</ul>
			<ul>
				<li>After creating profile then only you can use Update profile
					or apply for a job</li>
			</ul>
			<ul>
				<li>After applying to a job then only you can see status for
					applied jobs</li>
			</ul>

		</div>

	</div>

</body>
</html>


<script>
function recProfile(){
	$("#ajaxLoader").show();	
	window.location.href = 'redirectToDetails';
}


function jobPost(){
	$("#ajaxLoader").show();	
	window.location.href = 'recruiterPostingJobs';
}

</script>
