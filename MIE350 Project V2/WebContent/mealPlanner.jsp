<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>NeXtmeal</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->

<!-- <link rel="stylesheet" -->
<!-- 	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->



<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/mystyle2.css">
<link rel="stylesheet" type="text/css" href="css/mystyle3.css">

</head>

<!-- <style></style> -->


<body>
<%@ include file="navbar.jsp"%>
<header class="intro-mealPlanner">


<div class= "intro-body">
<div class="container-fluid text-center">
		<div class="row content">		
		<h1>Meal Planner</h1>
		
				<form role="form" method="post" action="recommendations.jsp">	
			<h2 style="font-size:34px";>Choose Your Preferences</h2><br>
			
			
			<div class="panel-group choosepanel" id="accordion" role="tablist" aria-multiselectable="false" >
				<div class="panel panel-default" >
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						  Price
						</a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							
							<div class="paneldiv">
									<input type="radio" name="optionsRadios0" id="optionsRadios01" value="option2" style="display:inline;width:8%" checked >
									<label for="firstname" class="control-label">Less than $</label>
									<input type="number" class="form-control" id="pricelessthan" placeholder="less than" style="display:inline;width:20%">
							</div>
							<div class="paneldiv">
									<input type="radio" name="optionsRadios0" id="optionsRadios00" value="option1" style="display:inline;width:8%"  >
									<label for="firstname" class="control-label"> Price doesn't matter to me</label>
<!-- 									<input type="number" class="form-control" id="pricefrom" placeholder="from" style="display:inline;width:30%"> -->
<!-- 									<label for="firstname" class="control-label">To </label> -->
<!-- 									<input type="number" class="form-control" id="priceto" placeholder="to" style="display:inline;width:30%"> -->
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
						  Calories
						</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
<!-- 							<div class="paneldiv"> -->
<!-- 								<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" style="display:inline;width:8%" checked >  -->
<!-- 								<label for="firstname" class="control-label">Greater than </label> -->
<!-- 								<input type="number" class="form-control" id="pricelessthan" placeholder="greater than" style="display:inline;width:50%"> -->
<!-- 							</div> -->
							<div class="paneldiv">
								<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" style="display:inline;width:8%" checked > 
								<label for="firstname" class="control-label">Equal </label>
								<input type="number" class="form-control" id="pricelessthan" placeholder="Equal" style="display:inline;width:50%">
							</div>
							<div class="paneldiv">
								<input type="radio" name="optionsRadios" id="optionsRadios3" value="option2" style="display:inline;width:8%" > 
								<label for="firstname" class="control-label">Less than </label>
								<input type="number" class="form-control" id="pricelessthan" placeholder="Less than" style="display:inline;width:50%">
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree">
					<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
					  Cuisine Type
					</a>
					</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingThree">
						<div class="panel-body">
							<input type="checkbox" name="optionsChecks" value="Chinese" style="display:inline;width:8%">Chinese
							<input type="checkbox" name="optionsChecks1" value="MiddleEastern" style="display:inline;width:8%">Middle Eastern
							<input type="checkbox" name="optionsChecks2" value="Japanese" style="display:inline;width:8%">Japanese
							<input type="checkbox" name="optionsChecks3" value="Mexican" style="display:inline;width:8%">Mexican
							<input type="checkbox" name="optionsChecks4" value="Fast Food" style="display:inline;width:8%">Fast Food
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFour">
					<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="true" aria-controls="collapseThree">
					  Dietary Restrictions
					</a>
					</h4>
					</div>
					
					<div id="collapseFour" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingFour">
					
					<div class="panel-body">						
							<div class="paneldiv">
								<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" style="display:inline;width:8%" checked > 
								<label for="firstname" class="control-label">Vegetarian </label>
							</div>
							<div class="paneldiv">
								<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" style="display:inline;width:8%" > 
								<label for="firstname" class="control-label">I'll eat anything </label>
							</div>
					</div>
					
					</div>
				</div>
				<div class="panel-collapse collapse in">
						<div class="panel-body">
							<button type="reset" class="btn btn-default" style="width:30%;">Reset</button>
							<button type="submit" class="btn btn-default" style="width:30%;">Submit</button>
						</div>
				</div>
			</div>
		</form>		
	  
		</div>
		
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</div>
</header>
<%@ include file="footer.jsp"%>
<script>
	$(document).ready(function() {
		$('#collapseOne').collapse('hide');
		$('#collapseTwo').collapse('hide');
		$('#collapseThree').collapse('hide');
		$('#collapseFour').collapse('hide');
		 
	});
</script>
</body>
</html>
