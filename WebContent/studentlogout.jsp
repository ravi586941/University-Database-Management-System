<!-- This JSP is used for ADMIN LOGOUT -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Logged Out</title>
</head>
<body>
<h3><center>Logged out Successfully</center></h3>
<%int s=(Integer)session.getAttribute("username");
System.out.println("studentlogout.jsp before session closing"+s);
session.invalidate();
System.out.println("studentlogout.jsp after session closing"+s);%>
<h3><center>Please <a href="admissionslogin.jsp">Login</a></center></h3>
<h3><center>Go to <a href="index.jsp">Homepage</a></center></h3>
</body>
</html>