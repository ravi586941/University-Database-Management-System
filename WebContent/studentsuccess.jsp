<%@page import="bean.AdmissionsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Student</title>
</head>
<body>
<%AdmissionsBean ab=(AdmissionsBean)request.getAttribute("studentdetails");%>
<%int uname=ab.getUserName(); 
System.out.println("Student success jsp"+uname);
session.setAttribute("username", uname);%>
<center><h3><font color="blue">Applied Student Details</font></h3>
<%=ab.getAdmittedmsg()%></center>

<table align="center">

<tr><td>User Id</td><td><%=ab.getUserName()%></td></tr>
<tr><td>FirstName</td><td><%=ab.getFirstName() %></td></tr>
<tr><td>LastName</td><td><%=ab.getLastName()%></td></tr>
<tr><td>Gender</td><td><%=ab.getGender()%></tr>
<tr><td>DATEOFBIRTH</td><td><%=ab.getDATEOFBIRTH()%></td><td></tr>
<tr><td>DepartmentName</td><td><%=ab.getDepartmentName()%></td></tr>
<tr><td>EmailID</td><td><%=ab.getEmailID()%></td></tr>
<tr><td>Address</td><td><%=ab.getAddress()%></td></tr>
<tr><td>PreferredYearSem</td><td><%=ab.getPreferredYearSem()%></td></tr>
</table>
<%if(ab.getAdmittedmsg().equalsIgnoreCase("Congratulations!! You are admitted in the University")) 

{%>
<table align="center">
<tr>
<td><a href="coursesregistration.jsp">Register for Courses</a></td>
<td><a href="<%=request.getContextPath()%>/UniversityController?action=listofavailablecourses">List of available Courses </a></td>
            
</tr>
</table>
	
<% }%>



<center><font color="red">Note: </font>The above details can not be changed
<a href="index.jsp">Home Page</a>&nbsp;
<a href="studentlogout.jsp">Logout</a></center>&nbsp;
</body>
</html>