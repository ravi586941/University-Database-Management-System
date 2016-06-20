<!-- This JSP is used to SHOW UPDATED DETAILS OF STUDENT IN UNIVERSITY -->

<%@page import="bean.StudentsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updated Student Details</title>
</head>
<body>
<%String s=(String)session.getAttribute("user");%>
<%System.out.println("In updatedstudent.jsp before going to object"); %>
<%StudentsBean us=(StudentsBean)request.getAttribute("studentupdate"); %>
<%System.out.println("In updatedstudent.jsp after object, the id is"+us.getStudentId()); %>
<center><h3><font color="blue">Updated Student Details</font></h3></center>
<center></center>
<table align="center">
<th border="1" colspan="2"></th>
<tr><td>StudentId</td><td><%=us.getStudentId()%></td></tr>
<tr><td>FirstName</td><td><%=us.getFirstName() %></td></tr>
<tr><td>LastName</td><td><%=us.getLastName()%></td></tr>
<tr><td>Gender</td><td><%=us.getGender()%></tr>
<tr><td>DATEOFBIRTH</td><td><%=us.getDATEOFBIRTH()%></td><td></tr>
<tr><td>DepartmentName</td><td><%=us.getDepartmentName()%></td></tr>
<tr><td>EmailID</td><td><%=us.getEmailID()%></td></tr>
<tr><td>Address</td><td><%=us.getAddress()%></td></tr>
<tr><td>JoinedYearSem</td><td><%=us.getJoinedYearSem()%></td></tr>
</table>
<center><a href="searchstudent.jsp">Update Another Student</a></center>
<center><a href="adminsuccess.jsp">Admin Home Page</a></center>
<center><a href="logout.jsp">Logout</a></center>

</body>
</html>