<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogOut Page</title>
</head>
<body>
<% String driverObject = (String) session.getAttribute("driverObject");%>
<% String CustomerObject = (String) session.getAttribute("CustomerObject");%>
<% if (session.getAttribute("DriverloggedIn") == "true") { %>
<div id='logout'>
<form action='<%=response.encodeUrl(request.getContextPath()) + "/LogoutServlet?action=driverlogout"%>' method='post' id='logoutform'>
<font size="3" color="#56c2e1">Welcome <%out.println(driverObject);%></font>
<input type='submit' value='LogOut' name='LogoutD' class="button2"/>
</form>

</div>

<% } else if(session.getAttribute("CustomerloggedIn") == "true") { %>
<div id='logout'>
<form action='<%=response.encodeUrl(request.getContextPath()) + "/LogoutServlet?action=customerlogout"%>' method='post' id='logoutform'>
<font size="3" color="#56c2e1">Welcome <%out.println(CustomerObject);%></font><br><br>
<input type='submit' value='LogOut' name='LogoutC' class="button2"/>
</form>
</div>
<%} else {%>
<div id="menu">
	<ul>
		<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/SignupServlet?action=createcustomer") %>" id="menu2" accesskey="2" title="">Register (Customer)</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/SignupServlet?action=createdriver") %>" id="menu3" accesskey="3" title="">Register (Driver)</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/LoginServlet?action=customerlogin") %>" id="menu4" accesskey="4" title="">Login (Customer)</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/LoginServlet?action=driverlogin") %>" id="menu5" accesskey="5" title="">Login (Driver)</a></li>
	</ul>
</div>
<%} %>
</body>
</html>