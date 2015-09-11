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
				<h2>Driver List</h2>
				<form method="post"
					action="<%=response.encodeUrl(request.getContextPath()
					+ "/ControllerLevel2?action=journeyplan")%>">

					<%
						String[] name = (String[])request.getAttribute("Array1");
						int[] dist = (int[])request.getAttribute("Array2");
					%>
					<table align="center">
						<tr>
							<td><h2>Name</h2></td>
							<td></td>
							<td></td>
							<td></td>
							<td><h2>Available Seats</h2></td>
						</tr>

						<%
							for (int i = 0; i < name.length; i++) {
						%>
						<tr></tr>
						<tr></tr>
						<tr>
							<td><a href="DriverInfo.jsp"><%=name[i]%></a></td>
							<td></td>
							<td></td>
							<td></td>
							<td><font size="5"><%=dist[i]%></font></td>
						</tr>
						<%
							}
						%>
					</table>


				</form>
			</div>

			<!-- <div id="news" class="boxedA">
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
			</div> -->
		</div>
	</div>
	<div id="footer">
		<center><h3>Join Us.</h3></center>
	</div>
</body>
</html>