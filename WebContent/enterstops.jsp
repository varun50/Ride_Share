<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Journey</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">
<body>
	<div id="menu">
		<ul>
			<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
			<li><a href="" id="menu5" accesskey="2" title="">View Live Blog</a></li>
		</ul>
	</div>
	<%@include file = "logout.jsp"%>
	<br>
	<br> 
	<br>
	<br>
	<div id="colB">
			<div class="boxedB">
				<h2>How to</h2>
				<ul>
					<li><a href="#">Edit Profile</a></li>
					<li><a href="#">View Live Blog</a></li>
					<li><a href="#">View Journey Details</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">About The Project</a></li>
				</ul>
			</div>

		</div>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Journey Details</h2>
				<form method="post"
					action="<%=response.encodeUrl(request.getContextPath()
					+ "/JourneyServlet?action=journeydetails")%>">
					<table>
						<tr>
							<td align="left">Enter Stop Location:</td>
							<td align="left"><select name="enterstops" style="width:205px">  
							<%@ page import= "java.util.*" %>  
							<%@ page import= "city.*" %>  
							<%
  								Cities c = new Cities();  
  								List <String > cityList  = c.getCities();  
  								for (String s:cityList)  
  								out.println("<option value="+s+">"+s+"</option>");
  							%>  
							</select></td>
						</tr>
						<tr>
						<td align="left"><input type="submit" name="Check_Available" value="Click To Add More Stop" class="button" onclick="form.action='<%=response.encodeUrl(request.getContextPath() + "/JourneyServlet?action=addstops")%>';" /></td>	
						</tr>
						<tr>
							<td align="left"></td>
							<td align="left"><input type="submit" value="Submit"/></td>
						</tr>
					</table>
					<font size="2" color="green"><b><%= request.getAttribute("msgstops") %></b></font>
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