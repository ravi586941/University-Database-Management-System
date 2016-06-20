<!-- This JSP is used to LOGIN for STUDENTS -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Login to Check Status</h2>

<form action="<%=request.getContextPath()%>/UniversityController" method="post">
<table align="center">
<tr><td colspan="2"><input type="text" name="username" placeholder="User ID"><td></tr>
<tr><td colspan="2"><input type="password" name="password"  placeholder="Password"></td></tr>
<tr><td></td></tr>

</table>
<center><input type="submit" name="studentlogin" value="Login"></center>
</form>
&nbsp;
<center>New User? <a href="admissionssignup.jsp">SignUP</a></center>
</body>
</html>