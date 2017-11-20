<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">neXtMeal</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="about.jsp">About</a></li>
				<li><a
					href="/mie350webapp/MenuController?action=listRestaurant">List all Menu Items</a></li>
				<li><a href="searchMenu.jsp">Search Menu Items</a></li>
				<li class="dropdown"><a data-toggle="dropdown"
					href="helpful_links.jsp">Example of a dropdown<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="sample_html.jsp">option 1</a></li>
						<li><a href="helpful_links.jsp">option 2</a></li>
						<li><a href="http://www.w3schools.com/html/default.asp">option 3</a></li>
						<li><a href="http://www.w3schools.com/bootstrap/">option 4</a></li>
					</ul></li>
				<li><a href="videotest.jsp">Video test</a></li>
			</ul>
			<!-- The following code can be added to include a Login button to the right-hand side of the navbar-->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>

		</div>
	</div>
</nav>