<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Journey Planner</title>
 <link rel="stylesheet" type="text/css" href="main.css">

<style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.imagetable th {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.imagetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
</head>
<body>
	<div id="menu">
		<ul>
			<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
		</ul>
	</div><br>
	<% String CustomerObject = (String) session.getAttribute("CustomerObject");%>
	<% if(session.getAttribute("CustomerloggedIn") == "true") { %>
	
	<div id='logout'>
	<form action='<%=response.encodeUrl(request.getContextPath()) + "/LogoutServlet?action=customerlogout"%>' method='post' id='logoutform'>
	<font size="3" color="#56c2e1">Welcome <%out.println(CustomerObject);%></font><br><br>
	<input type='submit' value='LogOut' name='LogoutC' class="button2"/>
	</form>
	</div>
	
	<%}%>
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
					<li><a href='<%= response.encodeUrl(request.getContextPath() + "/JourneyServlet?action=feedback")%>'>Give Feedback</a></li>
					<li><a href="#">About The Project</a></li>
				</ul>
			</div>
</div>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="model.User" %>
<% User user=(User) session.getAttribute("user");%>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Search Journey</h2>
					<table class="imagetable">
						<tr>
							<td align="left">DriverID</td>
							<td align="left"><%=user.getDriverID()%></td>
						</tr>
						<tr>
							<td align="left">CustomerId</td>
							<td align="left"><%=user.getCustomerId() %></td>
						</tr>
						<tr>
							<td align="left">Driver Name</td>
							<td align="left"><%=user.getDname()%></td>
						</tr>
						<tr>
							<td align="left">Date of Journey</td>
							<td align="left"><%=user.getDateofjourney()%></td>
						</tr>
						<tr>
							<td align="left">Initial destination</td>
							<td align="left"><%=user.getInidest()%></td>
						</tr>
						<tr>
							<td align="left">Final destination</td>
							<td align="left"><%=user.getFindest()%></td>
						</tr>
						<tr>
							<td align="left">No. of Stops</td>
							<td align="left"><%=user.getNoofstops()%></td>
						</tr>
						<tr>
							<td align="left">No. of Stops</td>
							<td align="left"><%=user.getNoofseats()%></td>
						</tr>
					</table>

			</div>
		<br>
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