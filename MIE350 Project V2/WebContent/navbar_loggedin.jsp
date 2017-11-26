<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                
                
                <a class="navbar-brand page-scroll" href="OwnerLogged.jsp">
                  <p>neXtMeal</p>
                </a>
                
            </div>

<!--             Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
<!--                     Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden active">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="OwnerLogged.jsp">Home</a>
                    </li>
         
					<li><a href="/mie350webapp/MenuController?action=listOwnersItems">My Menu</a></li>
	 				
	 				
                    <ul class="nav navbar-nav navbar-right">
				<li><a href="LogoutServlet"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</ul>
                    </ul>
            </div>
<!--             /.navbar-collapse -->
        </div>
<!--         /.container -->
    </nav>
