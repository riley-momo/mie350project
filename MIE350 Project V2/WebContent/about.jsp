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

</head>
<body>

	<%@ include file="navbar.jsp"%>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>About</h1>
				This application allows <a href="http://www.utoronto.ca">University of Toronto</a> engineering students to find food at a nearby restaurant
			 	It was developed for the course MIE350
				by the following students:<br>
				<ul>
					<li>Riley Moher</li>
					<li>Rao Fu</li>
					<li>Sijie Tian</li>
					<li>Akhil Mathur</li>
					<li>Houman Madani</li>
					<li>Hisham Radwan</li>
					<li>James Hanratty</li>
				</ul>
				As well, the following <b>open-source</b> tools were used:
				<ul>
					<li><a href="http://getbootstrap.com/">The Bootstrap CSS
							theme</a>, and</li>
					<li><a href="https://kryogenix.org/code/browser/sorttable/">Stuart
							Langridge's Sort Table JavaScript</a></li>
				</ul>
				<hr>
				<h2>INSERT EXTRA TEXT HERE</h2>
				<h2>Example of embedded image</h2>
				<img src="img/douggieboy.png"> <br />
				<br />
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>
