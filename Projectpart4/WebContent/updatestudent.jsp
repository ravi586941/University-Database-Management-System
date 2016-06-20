<!-- This JSP is used to UPDATE A STUDENT IN UNIVERSITY -->

<%@page import="bean.StudentsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%StudentsBean sb=(StudentsBean)request.getAttribute("student"); %>
<center><h2><font color="blue">Department Of COMPUTER SCIENCE</font></h2></center>
<center><h3><font color="blue">Student Details</font></h3></center>
<form name="form4" action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
<th border="1" colspan="2"></th>
<tr><td>StudentId</td><td><input type="text" value="<%=sb.getStudentId()%>" name="studentid"></tr>
<tr><td>FirstName</td><td><input type="text" value="<%=sb.getFirstName() %>" name="firstname"></tr>
<tr><td>LastName</td><td><input type="text" value="<%=sb.getLastName()%>" name="lastname"></tr>
<tr><td>Gender</td><td><input type="text" value="<%=sb.getGender()%>" name="gender"></tr>
<tr><td>DATEOFBIRTH</td><td><input type="text" value="<%=sb.getDATEOFBIRTH()%>" name="dob"><td></tr>
<tr><td>DepartmentName</td><td><input type="text" value="<%=sb.getDepartmentName()%>" name="departmentname"></tr>
<tr><td>EmailID</td><td><input type="text" value="<%=sb.getEmailID()%>" name="emailid"></tr>
<tr><td>Address</td><td><input type="text" value="<%=sb.getAddress()%>" name="address"></tr>
<tr><td>JoinedYearSem</td><td><input type="text" value="<%=sb.getJoinedYearSem()%>" name="joinedyearsem"></tr>
</table>
&nbsp;
<center><input type="submit" name="updatestudent" value="Update"></center>
        </form>
        <center><a href="logout.jsp">logout</a></center>
        <center><a href="adminsuccess.jsp">Admin Home Page</a></center>
</body>
</html>