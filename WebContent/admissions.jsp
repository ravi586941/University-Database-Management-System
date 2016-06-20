<!-- This JSP is used to SHOW ADMISSIONS HOME PAGE -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admissions</title>
<h2>Welcome to Admissions Page</h2>
</head>
<body>
<ul>
<li><a href="admissionslogin.jsp">International students click here</a></li><br/>
<li><a href="<%=request.getContextPath()%>/UniversityController?action=domesticStudents">domestic students click here</a></li><br/>

</ul>
</body>
</html>