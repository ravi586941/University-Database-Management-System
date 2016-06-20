<!-- This JSP is used for ADMIN LOGOUT -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Logged Out</title>
</head>
<body>
<h3><center>Logged out Successfully</center></h3>
<%String s=(String)session.getAttribute("user");
System.out.println("logout.jsp before session closing"+s);
session.invalidate();
System.out.println("logout.jsp after session closing"+s);%>
<h3><center>Please <a href="login.jsp">Login</a></center></h3>
<h3><center>Go to <a href="index.jsp">Homepage</a></center></h3>
</body>
</html>