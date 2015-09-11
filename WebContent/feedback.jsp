<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Driver Feedback</title>
</head>
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

<body>
<div id="menu">
	<ul>
		<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
	</ul>
</div>
<%@include file="logout.jsp"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="model.User" %>
<body>
<br><br><br><br>
<table class="imagetable">
<tr>
<th>DriverID</th>
<th>CustomerId</th>
<th>Driver Name</th>
<th>Date of Journey</th>
<th>Initial destination</th>
<th>Final destination</th>
<th>No. of Stops</th>
<th>No of Seats</th>
<th>Rating</th>
</tr>
	<% User user=(User) session.getAttribute("user");%> 
		    <tr>
		    <td><%=user.getDriverID()%></td>
		    <td><%=user.getCustomerId() %></td>
		    <td><%=user.getDname()%></td>
		    <td><%=user.getDateofjourney()%></td>
		    <td><%=user.getInidest()%></td>
		    <td><%=user.getFindest()%></td>
		    <td><%=user.getNoofstops()%></td>
		    <td><%=user.getNoofseats()%></td>
		    	
			<td><form action="Rating" method="post" action="<%=response.encodeUrl(request.getContextPath()+ "/Rating")%>">
            <input type="radio" name="rating" value="1" class="star">
            <input type="radio" name="rating" value="2" class="star">
            <input type="radio" name="rating" value="3" class="star">
            <input type="radio" name="rating" value="4" class="star">
            <input type="radio" name="rating" value="5" class="star">
            <input type="submit"></form></td>
            </tr>
    </table><br><br>
    <font size="2" color="green"><%= request.getAttribute("msg") %></font>
</body> 
</html>