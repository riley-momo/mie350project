<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<!-- Check to see if the user is logged in. Otherwise, redirect back to the login page.-->
<%
	session = request.getSession();
	System.out.println(session);
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("login.jsp");
	}
	
%>

<head>
<title>All Menu Items</title>
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
	


<header class="intro-AllMenuItems">
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>My Menu Items</h1>

				The time is now <b><%=new java.util.Date()%></b>.<br> <br>
<a class="btn btn-primary" href="MenuController?action=insert
&restaurantId=<c:out value="${restaurantID}"/>
&restaurantName=<c:out value="${restaurantName}"/>">Add A Menu Item!</a> 
		<br> <br>
		<div class="table-responsive">  
				<table border=1 class="sortable">
					<thead>
						<tr>
							<th>Name</th>
							<th>Restaurant Name</th>
							<th>Restaurant Rating</th>
							<th>Price ($)</th>
							<th>Calories</th>
							<th>Category</th>
							<th>Dietary Restrictions</th>
							
							<th colspan=2>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${menus}" var="menu">
							<tr>
								<td align="center"><c:out value="${menu.getItemName()}" /></td>
								<td align="center"><c:out value="${menu.getRestaurantName()}" /></td>
											<c:choose>
									<c:when test = "${menu.getRestaurantRating()==0}">
										<td align="center"><c:out value="" /></td>
									</c:when>
									<c:otherwise>
										<td align="center"><c:out value="${menu.getRestaurantRating()}" /></td>
									</c:otherwise>
								</c:choose>
								<td align="center"><c:out value="${menu.getPrice()}" /></td>
								
								<c:choose>
									<c:when test = "${menu.getCalories()>=0}">
										<td align="center"><c:out value="${menu.getCalories()}" /></td>
									</c:when>
									<c:otherwise>
										<td align="center"><c:out value="" /></td>
									</c:otherwise>
								</c:choose>
								
								<td align="center"><c:out value="${menu.getCategory()}" /></td>
								<td align="center"><c:out value="${menu.getDietary()}" /></td>
						
								
								<td align="center"><a class="btn btn-warning"
									href="MenuController?action=edit
									&itemName=<c:out value="${menu.getItemName()}"/>
									&restaurantId=<c:out value="${menu.getRestaurantID()}"/>
									">Edit</a></td>
									
									<td align="center"><a class="btn btn-danger"
									href="MenuController?action=delete
									&itemName=<c:out value="${menu.getItemName()}"/>
									&restaurantId=<c:out value="${menu.getRestaurantID()}"/>
									">Delete</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>
				<br /> <br />
			</div>
			
		</div>
	</div>
</header>
	<%@ include file="footer.jsp"%>


</body>
</html>