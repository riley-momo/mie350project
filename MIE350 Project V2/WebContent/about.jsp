<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - About</title>
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

	<%@ include file="navbar.jsp"%>
<header class= "intro-about">
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>About</h1>
				<p>This application allows <a href="http://www.utoronto.ca">University of Toronto</a> engineering students to find food at a nearby restaurant.
				</p><br>
				The following <b>open-source</b> tools were used:
				<ul>
					<li><a href="http://getbootstrap.com/">The Bootstrap CSS
							theme</a>, and</li>
					<li><a href="https://kryogenix.org/code/browser/sorttable/">Stuart
							Langridge's Sort Table JavaScript</a></li>
				</ul>

				<hr>

				</p>
		</header>
		
		<div class="intro-MeetTeam">
								
				<h1>Meet The Team</h1>
				<p>If you run into any issues with developing your web application,
				please post your questions in the course discussion board on
				Portal/Blackboard.</p> <br /> <br />
			
				<br />
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</header>

</body>
</html>
