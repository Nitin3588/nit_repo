<! DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css"/>



<style>


blink {
        animation: blinker 0.6s linear infinite;
        color: red;
       }


       @keyframes blinker {
	           50% { opacity: 0; }
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
    margin-top: 20px!important;
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
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
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
    padding-right: 16px!important;
}

.button1 {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

</style>

</head>
<body>
<div class="auth-form-reg px3">
<form action="" class="contact100-form validate-form">
	<div class="auth-form-header p-0">
		<h2 style="text-align:center">User Registration</h2>
	</div>


			<div id="MobDiv"  class="auth-form-body-reg mt-reg-3">

			<table border="0"">

			<tr>
			<td colspan="2"><button class="button button1 button3"><label style="color:black"><a href="SubscriberCreateProfile_PersonalDetails.html">Create Profile</label></button></td>

			<td colspan="2"><button class="button button1 button3"><label style="color:black">Update My Profile</label></button></td>

			<td colspan="1"><button class="button button1 button3"><label style="color:black">Show Profile Details</label></button></td>

			</tr>


			<tr>
			<td colspan="2"><button class="button button1 button3"><label style="color:black">Apply For a Job</label></button></td>

			<td colspan="2"><button class="button button1 button3"><label style="color:black">Status Of Applied Jobs</label></button></td>
			</tr>


			</table>

</div>

	<div class="auth-form-header p-0">
		<h2 style="text-align:center">Recruiter's  Profile</h2>
	</div>

			<div id="MobDiv1"  class="auth-form-body-reg mt-reg-3">

			<table border="0"">

			<tr>
			<td colspan="2"><button class="button button1 button3" onclick="recProfile()"><label style="color:black">Create Recruiter's Profile</label></button></td>

			<td colspan="2"><button class="button button1 button3"><label style="color:black">Update Recruiter's Profile</label></button></td>

			<td colspan="1"><button class="button button1 button3"><label style="color:black">Show Recruiter's Profile Details</label></button></td>

			</tr>


			<tr>
			<td colspan="2"><button class="button button1 button3"><label style="color:black"><blink><a href="recruiterPostingJobs.html">
			Post a new job</a></blink></label></button></td>

			<td colspan="2"><button class="button button1 button3"><label style="color:black">Status Of posted Jobs</label></button></td>
			</tr>


			</table>


		</div>









	</form>




		<div id="notesDiv" style="" class="notes">
		<strong>Note</strong>
		<ul>
			<li>Use Create Profile Option to fill up personal details and contact details </li>
		</ul>
		<ul>
			<li>After creating profile then only you can use Update profile or apply for a job </li>
		</ul>
		<ul>
			<li>After applying to a job then only you can see status for applied jobs</li>
		</ul>

	</div>





</div>
</body>
</html>


<script>
function recProfile(){
window.location.href = 'recruitBasicDetails.html';
}
</script>
