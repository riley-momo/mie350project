<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>NeXtmeal - Create Account</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->
<!-- <link rel="stylesheet" -->
<!-- 	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/mystyle2.css">


</head>
<body>

	
<header class="intro-login">
<%@ include file="navbar.jsp"%>
	<div class="container-fluid text-center">
		<div class="row content">
				<div class="col-sm-8 text-left" style="width:100%;">
				<h1 style="font-size: 88px;">Create Account</h1>
				
				

				<form>
				<p style="font-size: 28px;">What's your name?</p>
				<input type="text" name="nm" maxlength="20" style="font-size: 34px; margin-left:inherit; width:30%" />
				<br>
				<p style="font-size: 28px;">Enter an Email:</p>
				<input type="text" name="em" maxlength="20" style="font-size: 34px; margin-left:inherit; width:30%" />
				<br>
				<p style="font-size: 28px;">Set Password: </p>
				<input	type="password" name="pw" maxlength="20" style="font-size: 25px; margin-left:inherit; width: 30%"/>
				<br>
				
				<input type="submit" 
						class="btn btn-info" value="Create Account" style="background-color: #a94442; border-color: rgba(0,0,0,.0001);width:30%; ">
				
				</form>
				<br>
				
			
				
								
				<br/> 
				<p style="font-size:14px";>For demonstration purposes, please use the following
				credentials:
				<br>
					Email: jeff@fake.com
				<br>
					Password: 123456</li>
				</p>				
			</div>
		</div>
	</div>
</header>

	<%@ include file="footer.jsp"%>

</body>
</html>