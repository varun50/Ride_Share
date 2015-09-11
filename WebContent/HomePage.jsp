<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>

<link rel="stylesheet" type="text/css" href="NewFile.css">
<body>
<div class ="background-image">

<%@include file="logout.jsp"%>
<% if (session.getAttribute("DriverloggedIn")!= "true" && session.getAttribute("CustomerloggedIn")!= "true") { %>
<br><br><br><br>
	<div id="colB">
		<div class="boxedB">
			<h2>How to</h2>
			<ul>
				<li><a href="#">Get A ride</a></li>
				<li><a href="#">View Live Blog</a></li>
				<li><a href="abousus.jsp">Contact Us</a></li>
				<li><a href="<%=response.encodeUrl(request.getContextPath() + "/LoginServlet?action=customerlogin") %>">Give Feedback</a></li>
				<li><a href="contactus.jsp">About The Project</a></li>
			</ul>
		</div>
	</div>
<div id="content">
	<div id="colA">
		<div id="welcome" class="boxedA">
			<h2>Welcome to RideShare!</h2>
			<hr>
			<!-- <img src="images/carmain.jpg" alt="" width="130" height="150" style="float: right; margin: 0.5em 0 0 1.5em;" />-->
			<p align = "justify"><strong>RideShare</strong> is a a web application that would make traveling for a user more efficient and simple.It is mainly targeted towards students and people who do not have the convenience of a private vehicle.</p>
			</br>
		    <hr>
		</div>
		<div class="new">
			<h2 class="hidden">Live Blog &amp; Updates</h2>
			<ul class="hidden">
				<li class="hidden">
					<h3 class="hidden">31st March 2014</h3>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
				<li class="hidden">
					<h3>2nd April 2014</h3>
					<h4>Traveling To New York.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
			</ul>
		</div>
	</div>
	</div>	
	
<div id="footer">
	<center><h3>Join Us.</h3></center>
</div>
<%} else if (session.getAttribute("CustomerloggedIn") != null ) {%>
<br><br><br><br>
	<div id="colB">
		<div class="boxedB">
			<h2>How to</h2>
			<ul>
				<li><a href="<%=response.encodeUrl(request.getContextPath() + "/JourneyServlet?action=journeyplanner") %>">Journey Planner</a></li>
				<li><a href="#">Edit Profile</a></li>
				<li><a href="#">Get A ride</a></li>
				<li><a href="#">View Live Blog</a></li>
				<li><a href="#">View Journey Details</a></li>
				<li><a href="abousus.jsp">Contact Us</a></li>
				<li><a href="<%=response.encodeUrl(request.getContextPath() + "/JourneyServlet?action=feedback") %>">Give Feedback</a></li>
				<li><a href="contactus.jsp">About The Project</a></li>
			</ul>
		</div>
		</div>
		<div id="content">
		<div id="colA">
		<div id="welcome" class="boxedA">
			<h2>Welcome to RideShare!</h2>
			<hr>
			<center><b><font size="6" color="green">You Are Currently Logged In</font></b></center>
			</br>
		    <hr>
		</div> 
		</div>
	<div class="new">
			<h2 class="hidden">Live Blog &amp; Updates</h2>
			<ul class="hidden">
				<li class="hidden">
					<h3 class="hidden">31st March 2014</h3>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
				<li class="hidden">
					<h3>2nd April 2014</h3>
					<h4>Traveling To New York.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
			</ul>
		</div>
		</div>
	
	<% } else if (session.getAttribute("DriverloggedIn") != null) {%>
<br><br><br><br>
	<div id="colB">
		<div class="boxedB">
			<h2>How to</h2>
			<ul>
				<li><a href="<%=response.encodeUrl(request.getContextPath() + "/JourneyServlet?action=postjourney") %>">Post Journey</a></li>
				<li><a href="#">View Live Blog</a></li>
				<li><a href="abousus.jsp">Contact Us</a></li>
				<li><a href="#">Give Feedback</a></li>
				<li><a href="contactus.jsp">About The Project</a></li>
			</ul>
		</div>
		</div>
		<div id="content">
		<div id="colA">
		<div id="welcome" class="boxedA">
			<h2>Welcome to RideShare!</h2>
			<hr>
			<center><b><font size="6" color="green">You Are Currently Logged In</font></b></center>
			</br>
		    <hr>
		</div> 
		</div>
	<div class="new">
			<h2 class="hidden">Live Blog &amp; Updates</h2>
			<ul class="hidden">
				<li class="hidden">
					<h3 class="hidden">31st March 2014</h3>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<h4 class="hidden">Traveling To Boston.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
				<li class="hidden">
					<h3>2nd April 2014</h3>
					<h4>Traveling To New York.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
			</ul>
		</div>
		</div>
	<%} %>
</div>

<%if (session.getAttribute("logout")!= null) {%>
		<br/><h3 align="center"><%=session.getAttribute("logout")%></h3>
		<%session.invalidate(); %>
		<%}%>
</body>
</html>