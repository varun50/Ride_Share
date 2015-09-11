<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Journey Planner</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">
<body>
	<div id="menu">
		<ul>
			<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
			<li><a href="#" id="menu2" accesskey="2" title="">About The
					Project</a></li>
		</ul>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div id="colB">
			<div class="boxedB">
				<h2>How to</h2>
				<ul>
					<li><a href="#">Get A ride</a></li>
					<li><a href="#">Edit Profile</a></li>
					<li><a href="#">View Live Blog</a></li>
					<li><a href="#">View Journey Details</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Give Feedback</a></li>
				</ul>
			</div>

		</div>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Ride Confirmation</h2>
				<%
					String name = "John kepler";
					long no = 518434334;
					//String lang= "English, Spanish";
					//String license= "DEW123FEWEF";
					//double Ratings= 4.1;
					String car_n = "Toyota camry";
					String car_no = "ABC 1234";
					//String type = "4 doors";
				%>
				</br><h3>Your reservation summary for order ABC123</h3>
				<div id="container">
					<div class="r_c">
						<h2>Driver Details</h2>
						<p align="left">
							<b>Name:</b>
							<%=name%><br /> <b>Phone:</b>
							<%=no%><br />
					</div>
					<div class="r_c">
						<h2>Car Details</h2>
						<p align="left">
							<b>Name:</b>
							<%=car_n%><br /> <b>Number:</b>
							<%=car_no%><br />
					</div>
					<div class="r_c">
						<p align="left">
							<b>Details have been sent to you via sms and email</b><br />
							<b>Thank you for making a reservation with RideShare</b><br />
							<b>This confirms your reservation</b><br />
					</div>

				</div>
			</div>

			<div id="news" class="boxedA">
				<h2>Live Blog &amp; Updates</h2>
				<ul>
					<li>
						<h3>31st March 2014</h3>
						<p>Traveling To Boston.</p>
						<p class="more">
							<a href="#">View Journey</a>
						</p>
					</li>
					<li>
						<h3>2nd April 2014</h3>
						<p>Traveling To New York.</p>
						<p class="more">
							<a href="#">View Journey</a>
						</p>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="footer">
		<center><h3>Join Us.</h3></center>
	</div>
</body>
</html>