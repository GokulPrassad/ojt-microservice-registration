<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="css/registrationCss.css" />

<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/
     jquery/3.3.1/jquery.min.js">
     
    
     
    </script>


<script type="text/javascript">
    function func()
{


const thisForm = document.getElementById('user_list');
thisForm.addEventListener('submit', async function (e) {
	
    e.preventDefault();
    const formData = new FormData(thisForm).entries()
    const response = await fetch('http://localhost:9198/userInfo/user/', {  
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(Object.fromEntries(formData))
        
    })
    window.location = "/login";
    const result = await response.json();
    console.log(result)
});

}
    </script>
    
    <style>*{
	margin:0px;
	padding:0px;
  }

.bg{
	font-family:Tahoma, Geneva, sans-serif;
	background-repeat: no-repeat;
    height:800px;
	    color: #fff;
    background: -webkit-linear-gradient(110deg, #000 33%, rgba(0, 0, 0, 0) 33%), -webkit-linear-gradient(110deg, #dd0000 66%, #ffc608 66%);
    background: -o-linear-gradient(110deg, #000 33%, rgba(0, 0, 0, 0) 33%), -o-linear-gradient(110deg, #dd0000 66%, #ffc608 66%);
    background: -moz-linear-gradient(110deg, #000 33%, rgba(0, 0, 0, 0) 33%), -moz-linear-gradient(110deg, #dd0000 66%, #ffc608 66%);
    background: linear-gradient(110deg, #000 33%, rgba(0, 0, 0, 0) 33%), linear-gradient(110deg, #dd0000 66%, #ffc608 66%);
    }
	.error {
      color: red;
      
   }
#container{
	width:550px;
	background-color:rgba(250,250,252,.9);
	margin:auto;
	margin-top:10px;
	margin-bottom:10px;
	box-shadow:0 0 3px #999;
	}
	

#container_body{
	padding:20px;
	}
	
.form_title{
	font-size:35px;
	color:#141823;
	text-align:center;
	padding:10px;
	font-weight:normal;
	}
	
.head_para{
	font-size:19px;
	color:#99a2a7;
	text-align:center;
	font-weight:normal;
	}
#form_name{
	padding:25px 0 0 15px;
	}
.firstnameorlastname{
	 margin-right:20px;
	}
.input_name{
	width:207px;
	padding:5px;
	font-size:18px;
	}
#userName{
	clear:both;
	padding:15px 0 10px 0px;
	}
.input_container{
	width:434px;
	padding:5px;
	font-size:18px;
	}
#address{
	padding:10px 0 10px 0px;
	}

#password_form{
	padding:10px 0 10px 0px;
	}


select{
	padding:5px;
	}

#radio_button{
	padding:10px 0 0 0;
	}
#sign_user{
	font-size:14px;
	color:#FFF;
	text-align:center;
	background-color:#3B5998;
	padding:10px;
	margin-top:10px;
	cursor: pointer;
	}
#errorBox{
	color:#F00;
	}</style>
</head>

<div class="bg">
	<!------------------------------------------------container start--------------------------------------->
	<div id="container">

		<div id="container_body">

			<div>
				<img src="image\final_logo-removebg-preview.png" alt="logo"
					width="400" height="233"
					style="background-color: black; margin-left: 60px;">
				<h2 class="form_title">Registration</h2>
			</div>

			<!--------------------------------------Form  start----------------------------------------------------------------------->
			<div id="form_name">
				<form action="save" id="user_list" name="registration"
					modelAttribute="userList" method="POST">
					<jsp:useBean id="GuruTest" class="com.example.microserviceRegistration.model.UserList" />
					<div class="firstnameorlastname">


						<div id="errorBox"></div>

						<input type="text" id="firstName" name="firstName" value=""
							placeholder="First Name" class="input_name" required> <input
							type="text" id="lastName" name="lastName" value=""
							placeholder="Last Name" class="input_name" required>
					</div>


					<div id="userName">
						<input type="text" id="userName" name="userName" value=""
							placeholder="User name" class="input_container" required>
					</div>

					<div id="password_form">
						<input type="password" id="password" name="password" value=""
							placeholder="Password" class="input_container" required>
					</div>


					<div id="address">
						<input type="text" id="address" name="address" value=""
							placeholder="Address" class="input_container" required>
					</div>


					<div id="address">
						<input type="text" id="phoneNo" name="phoneNo" value=""
							placeholder="Contact No" class="input_container" required>
					</div>




					<div>
						<input type="submit" value="Register" id="sign_user"
							onclick="func()" style="margin-left: 180px">

					</div>
					 <p style="margin-left: 80px"><a href="/login">Login</a></p>
                    
					
				</form>
			</div>




		</div>
		<!----------------------------------------------form ends------------------------------>
	</div>

</div>


<script type="text/javascript">



$(document).ready(function(){

	/* $('#usercheck').hide();   
	    let usernameError = true;
	    $('#firstName').keyup(function () {
	        validateUsername();
	    });
	    
	    function validateUsername() {
	        let usernameValue = $('#firstName').val();
	       if (usernameValue.length == 0) {
	        $('#usercheck').show();
	        $('#usercheck').html
	  	  ("**Enter user name");
	            usernameError = false;
	            return false;
	        }
	       if((usernameValue.length < 3)||
	                (usernameValue.length > 10)) {
	            $('#usercheck').show();
	            $('#usercheck').html
	  ("**length of username must be between 3 and 10");
	            usernameError = false;
	            return false;
	        }
	        else {
	            $('#usercheck').hide();
	        }
	      }*/
	
	  $("#user_list").validate({
	    rules:{
	    	
	      password:{
	        required:true,
	        minlength:6
	      },
	      phoneNo:{
	        required:true,
	        digits:true,
	        minlength:10,
	        maxlength:10
	      },
	      address:{required:true}

	    },
	    messages:{
	    	
	      firstName:"Enter first name",
	      lastName:"Enter last name",
	      userName:"Enter User name",
	      email:{
	        required:"Enter email Id",
	        email:"Enter valid email"
	      },
	      password:{
	        required:"Enter the password",
	        minlength:"Minimum length must be 6 "
	      },
	      phoneNo:{
	        required:"Enter the Mobile Number",
	        digits:"Enter only number",
	        maxlength:"No of digits  should be 10 "
	      },
	      address:{
	    	  required:"Enter the address"
	      },
	      
	    }

	  });

	});

</script>

</html>
