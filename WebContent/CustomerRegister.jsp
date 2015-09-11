<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">
<body>
	<div id="menu">
		<ul>
			<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
			<li><a href="#" id="menu2" accesskey="2" title="">About The
					Project</a></li>
			<li><a href="#" id="menu3" accesskey="3" title="">Get A Ride</a></li>
			<li><a href="<%= response.encodeUrl(request.getContextPath() + "/LoginServlet?action=customerlogin") %>" id="menu4" accesskey="4" title="">Login
					(Customer)</a></li>
		</ul>
	</div>
	<br><br><br><br>
	<div id="colB">
			<div class="boxedB">
				<h2>How to</h2>
				<ul>
					<li><a href="#">Get A ride</a></li>
					<li><a href="#">View Live Blog</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Give Feedback</a></li>
				</ul>
			</div>
		</div>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Customer Registration</h2>
				<p>Enter your details for Registration</p>
				<form method="post"
					action="<%=response.encodeUrl(request.getContextPath()+ "/SignupServlet?action=createcustomer")%>">

					<input type="hidden" name="action" value="createcustomer" />
					<table>
						<tr>
							<td align="left">First Name:</td>
							<td align="left"><input type="text" name="FirstName" value="<%=request.getAttribute("FirstName")%>" size="30"/></td>
						</tr>
						<tr>
							<td align="left">Last Name:</td>
							<td align="left"><input type="text" name="LastName" value="<%=request.getAttribute("LastName")%>" size="30"/></td>
						</tr>
						<tr>
							<td align="left">Email:</td>
							<td align="left"><input type="text" name="Email" value="<%=request.getAttribute("email")%>" size="30"/></td>
						</tr>
						
						<tr>
						<td align="left"><input type="submit" name="Check_Available" value="Check Available" class="button" onclick="form.action='<%=response.encodeUrl(request.getContextPath() + "/SignupServlet?action=checkcustomer")%>';" /></td>	
						</tr>
						
						<tr>
							<td align="left">Password:</td>
							<td align="left"><input type="password" name="password" size="30"/></td>
						</tr>
						<tr>
							<td align="left">Re enter password:</td>
							<td align="left"><input type="password" name="repeatpassword" size="30"/></td>
						</tr>
						
						<tr>
							<td align="left">DOB (MM/DD/YYYY):</td>
							<td align="left"><input type="text" name="dob" value="<%=request.getAttribute("DOB")%>" size="30"/></td>
						</tr>

						<tr>
							<td align="left">Address Line 1:</td>
							<td align="left"><input type="text" name="add1" value="<%=request.getAttribute("address1")%>" size="30"/></td>
						</tr>

						<tr>
							<td align="left">Address Line 2:</td>
							<td align="left"><input type="text" name="add2" value="<%=request.getAttribute("address2")%>" size="30"/></td>
						</tr>

						<tr>
							<td align="left">City/State:</td>
							<td align="left"><select name="custdropdown" style="width:205px">  
							<%@ page import= "java.util.*" %>  
							<%@ page import= "city.*" %>  
							<%
  								Cities c = new Cities();  
  								List <String> cityList  = c.getCities();  
  								for (String s:cityList)  
  								out.println("<option value="+s+">"+s+"</option>");
  							%>  
							</select></td>
						</tr>
						<%-- <tr>
							<td align="left">State:</td>
							<td align="left"><input type="text" name="state" value="<%=request.getAttribute("state")%>" size="30"/></td>
						</tr> --%>
						<tr>
							<td align="left">Zip:</td>
							<td align="left"><input type="text" name="zip" value="<%=request.getAttribute("zip")%>" size="30"/></td>
						</tr>
						<tr>
							<td align="left">Contact Number:</td>
							<td align="left"><input type="text" name="cnumber" value="<%=request.getAttribute("contactnumber")%>" size="30"/></td>
						</tr>
						<tr>
							<td align="left"></td>
							<td align="left"><input type="submit" value="Submit" /></td>
						</tr>
					</table>

					<p class="message"><font size="2" color="red"><%=request.getAttribute("message")%></font></p>

				</form>
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