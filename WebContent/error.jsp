<!-- This JSP is used to SHOW ERROR OF ALREADY REGISTERED COURSES -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Error</title>
</head>
<body>
<table  align="center">

<tr>
<td><h1>
<font color="red">

<%=request.getAttribute("registercourses") %></font></h1>
</td>
</tr>
</table>

</body>
</html>