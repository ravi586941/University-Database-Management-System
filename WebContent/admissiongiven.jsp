<!-- This JSP is used to SHOW SUCCESS MESSAGE FOR ADMITTED STUDENTS -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admitted</title>
</head>
<body>
<%String s=(String)session.getAttribute("user");
System.out.println("addcourse.jsp"+s);%>
<center><h3><font color="blue">Selected students were ADMITTED successfully.</font><br/>
<a href="logout.jsp">Logout</a><br/>
<a href="adminsuccess.jsp">Admin Home Page</a><br/>
<a href="index.jsp">Home page</a></h3></center>
</body>
</html>