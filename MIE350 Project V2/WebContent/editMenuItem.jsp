<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Edit Menu Item</title>
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
			<div class="col-sm-8 text-left">
				<h1 style="font-size:60px;">Edit A Menu Item</h1>
			
			 <br>
				<br>
				
				
				
				
<!-- **********************Backend Info that needs to be updated******************************* -->
				<form method="POST" action='MenuController' name="frmAddItem">
					Restaurant Name*: <input type="text" readonly="readonly"
						name="restaurantName" value="<c:out value="${menu.restaurantName}" />"><br>
					Item Name*: <input type="text" readonly = "readOnly" 
					name="itemName" value="<c:out value="${menu.itemName}" />"><br>
					Price : <input type="text" name="price"
						value="<c:out value="${menu.price}" />"><br>					
					Calories: <input type="text" name="calories"
						value="<c:out value="${menu.calories}" />"><br> <br>
					Category: <input type="text" name="category"
						value="<c:out value="${menu.category}" />"><br> <br>
					Dietary Restrictions: <input type="text" name="dietary"
						value="<c:out value="${menu.dietary}" />"><br> <br>
					<input type="submit" class="btn btn-info" value="Submit" />
				</form>
<!-- **********************Backend Info that needs to be updated******************************* -->




			</div>
			
		</div>
	</div>
	</header>
	<%@ include file="footer.jsp"%>


</body>
</html>
