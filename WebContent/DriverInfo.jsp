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
			<li class="first"><a href="#" id="menu1" accesskey="1" title="">Home</a></li>
			<li><a href="#" id="menu2" accesskey="2" title="">About The
					Project</a></li>
		</ul>
	</div>
	<br><br><br><br>
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
				<h2>Driver Information</h2>
					<%
						String name = "John Kepler";
						long no = 518434334;
						String lang = "English, Spanish";
						String license = "DEW123FEWEF";
						String car = "Ford Fusion";
						int seats = 3;
						String ETA = "17 min";
					%>
					<p align="left">
					<h4>
						<b>Name:</b>
						<%=name%></h4>
					<h4>
						<b>Phone:</b>
						<%=no%></h4>
					<h4>
						<b>Languages:</b>
						<%=lang%></h4>
					<h4>
						<b>License:</b>
						<%=license%></h4>
					<h4>
						<b>Car:</b>
						<%=car%></h4>
					<h4>
						<b>Seats:</b><%=seats%></h4>
					<h4>
						<b>ETA:</b><%=ETA%></h4>
					<h4>
						<INPUT TYPE="SUBMIT" NAME="submit" VALUE="Select Driver and Confirm Order"
							onClick="javascript:window.location='Confirmation.jsp'">
					</h4>
						<!-- <img src="images/carmain.jpg" />-->
				
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