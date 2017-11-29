<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Invalid Rating!</title>
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/mystyle2.css">
</head>
<body>

	<%@ include file="navbar_Studentloggedin.jsp"%>
<header class="intro-invalidLogin">
	<div class="container-fluid text-center">
		<div class="row content">
			
			<div class="col-sm-8 text-left">

				<h1>Oops...</h1>

<br>
<br>
				<h2>Looks like you've already rated this restaurant!</h2>
				
				<br>
				<form action="StudentLogged.jsp">
				<input type="submit" 
						class="btn btn-info" value="Return Home" style="background-color: #a94442; border-color: rgba(0,0,0,.0001);width:30%; ">
				</form>
				<br>
				<br>
				
				<br>
				<br>
				<br>
				<br>

			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>
</header>
	<%@ include file="footer.jsp"%>


</body>
</html>