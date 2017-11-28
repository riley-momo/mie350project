<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Check to see if the user is logged in. Otherwise, redirect back to the login page.-->
<%
 	session = request.getSession();
 	System.out.println(session);
//  	if (session.getAttribute("userName") == null) {
//  		response.sendRedirect("login.jsp");
//  	}
	
%>
<html lang="en">
<head>
<title>Rate a Restaurant- neXtMeal</title>
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

	<%@ include file="navbar_loggedin.jsp"%>

<%
 		User user = (User) session.getAttribute("currentSessionUser");
 		String username = (String) session.getAttribute("userName");
 		String email= (String) session.getAttribute("email");
%>
<header class="intro-addMenuItem">
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-center">
				<h1 style="font-size:60px;">Rate a Restaurant!</h1>
			
			 <br>
				<br>
	
				
				
<!-- **********************Backend Info that needs to be updated******************************* -->
				
				<h2>You are Currently Rating: <c:out value="${menu.restaurantName}" /></h2>
				
	<br>

				
				<h4 style="color:white;">	Rating (required): </h4>
		<form class="form-inline" role="form">
  		<div class="form-group">
   	 <select class="form-control">
  					<option value="1">1 Star</option>
 					<option value="2">2 Star</option>
  					<option value="3">3 Star</option>
  					<option value="4">4 Star</option>
  					<option value="5">5 Star</option>
					</select>
  </div>
  <div class="form-group">
    <button type="submit" class="btn btn-info" style="width:150%">Submit Rating</button>
  </div>

</form>
<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<!-- **********************Backend Info that needs to be updated******************************* -->




			</div>
			
		</div>
	</div>
	</header>
	<%@ include file="footer.jsp"%>


</body>
</html>
