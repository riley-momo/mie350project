<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Meal Finder</title>
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
<!-- <style></style> -->


<body>
<%@ include file="navbar.jsp"%>


<header class="intro-home">
<div class= "intro-body">
<div class="container-fluid text-center">
		<div class="row content">		
			<h1>Welcome to NeXtmeal</h1>
			<br>
				<p style="font-size: 24px;">The application that lets you find
				the right meal, at the right time!</p>
			<br>
			<br>
			<br>
			<br>
			
			
			<form action="mealPlanner.jsp">
			<input type="submit" 
						class="btn btn-info" value="Let's Get Started!" 
						style="background-color: #da2926; border-color: rgba(0,0,0,.0001); font-size:18px;">
			</form>		
				<p>To learn more about this web application, <a href="about.jsp">Click here!</a></p>
			</div>
	  
<br>
	<br>
	<br>
	<br>
	<br>

	
</div>
</header>
	<%@ include file="footer.jsp"%>

</body>
</html>
