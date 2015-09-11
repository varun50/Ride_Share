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
			<li><a href="<%= response.encodeUrl(request.getContextPath() + "/LoginServlet?action=driverlogin") %>" id="menu3" accesskey="3" title="">Login (Driver)</a></li>
		</ul>
	</div>
	<br><br><br><br>
	<div id="colB">
			<div class="boxedB">
				<h2>How to</h2>
				<ul>
					<li><a href="#">View Live Blog</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Give Feedback</a></li>
				</ul>
			</div>

		</div>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Driver Registration</h2>

				<p>Enter your details for Registration</p>
				<form method="post"
					action="<%=response.encodeUrl(request.getContextPath()
					+ "/SignupServlet?action=updatedriver")%>">

					<input type="hidden" name="action" value="createdriver" />
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
							<td align="left">Email address:</td>
							<td><input type="text" name="email" value="<%=request.getAttribute("email")%>" size="30" />
						</tr>
						
						<%-- <tr>
						<td align="left"><input type="submit" name="Check_Available" value="Check Available" class="button" onclick="form.action='<%=response.encodeUrl(request.getContextPath() + "/SignupServlet?action=checkdriver")%>';" /></td>	
						</tr> --%>
					
						<tr>
							<td align="left">Password:</td>
							<td><input type="password" name="password" value="" size="30"/></td>
						</tr>

						<tr>
							<td align="left">Repeat password:</td>
							<td><input type="password" name="repeatpassword" value="" size="30"/></td>
						</tr>
						
						<tr>
							<td align="left">DOB (MM/DD/YY):</td>
							<td align="left"><input type="text" name="Dob" value="<%=request.getAttribute("DOB")%>" size="30"/></td>
						</tr>
						
						<tr>
							<td align="left">Address Line 1:</td>
							<td align="left"><input type="text" name="Add1" value="<%=request.getAttribute("address1")%>" size="30"/></td>
						</tr>

						<tr>
							<td align="left">Address Line 2:</td>
							<td align="left"><input type="text" name="Add2" value="<%=request.getAttribute("address2")%>" size="30"/></td>
						</tr>
						
						<tr>
							<td align="left">Contact Number:</td>
							<td align="left"><input type="text" name="contactnumber" value="<%=request.getAttribute("contactnumber")%>" size="30"/></td>
						</tr>

						<tr>
							<td align="left">City/State:</td>
							<td align="left"><select name="driverdropdown" style="width:205px">  
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
						
						<%-- <tr>
							<td align="left">State:</td>
							<td align="left"><input type="text" name="State" value="<%=request.getAttribute("state")%>" size="30"/></td>
						</tr> --%>
						
						<tr>
							<td align="left">zip:</td>
							<td align="left"><input type="text" name="zip" value="<%=request.getAttribute("zip")%>" size="30"/></td>
						</tr>
					</table>
					<h3>License Details</h3>
					<br>
					<table>
						<tr>
							<td align="left">License Number:</td>
							<td align="left"><input type="text" name="Lnum" value="<%=request.getAttribute("licenseno")%>" size="30"/></td>
						</tr>
						<tr>
							<td align="left">Date Of issue:</td>
							<td align="left"><input type="text" name="Doi" value="<%=request.getAttribute("dateofissue")%>" size="30"/></td>
						</tr>
						<tr>
							<td align="left">Date Of expiration:</td>
							<td align="left"><input type="text" name="Doe" value="<%=request.getAttribute("dateofexpiry")%>" size="30"/></td>
						</tr>
					</table>
					<h3>Car Details</h3>
					<br>
					<table>
						<tr>
							<td align="left">Car Model Name:</td>
							<td align="left"><input type="text" name="Cname" value="<%=request.getAttribute("carmodel")%>" size="30"/></td>
						</tr>
						<tr>
							<td align="left">Car Type:</td>
							<td align="left"><input type="text" name="Ctype" value="<%=request.getAttribute("cartype")%>" size="30"/></td>
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